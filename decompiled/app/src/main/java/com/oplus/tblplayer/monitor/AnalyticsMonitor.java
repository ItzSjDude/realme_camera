package com.oplus.tblplayer.monitor;

import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.oplus.tblplayer.ffmpeg.FfmpegAudioRenderer;
import com.oplus.tblplayer.ffmpeg.FfmpegVideoRenderer;
import com.oplus.tblplayer.managers.TBLSourceManager;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.NetSpeedUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class AnalyticsMonitor implements AnalyticsListener, TransferListener, ErrorCode {
    private static final String TAG = "AnalyticsMonitor";
    private long alreadyPreCacheBytes;
    private boolean audioRendererHasFailed;
    private String errorRendererInfo;
    private boolean hasRenderFirstFrame;
    private TrackGroupArray lastSeenTrackGroupArray;
    private SimpleExoPlayer mExoPlayer;
    private MediaInfo mMediaInfo;
    private MediaUrl mMediaUrl;
    private Report.Builder mReportBuilder;
    private boolean rebuffering;
    private long rebufferingStartTimeMs;
    private long startTimeMs;
    private long totalNetworkReadBytes;
    private long totalRebufferCount;
    private long totalRebufferTimeMs;
    private DefaultTrackSelector trackSelector;
    private boolean videoRendererHasFailed;
    private long firstRenderTime = 0;
    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;
    private boolean isStarted = false;

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    public AnalyticsMonitor(SimpleExoPlayer simpleExoPlayer, DefaultTrackSelector defaultTrackSelector) {
        this.mExoPlayer = simpleExoPlayer;
        this.trackSelector = defaultTrackSelector;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onReadingStarted(AnalyticsListener.EventTime eventTime) {
        LogUtil.m25450d(TAG, "onReadingStarted");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        LogUtil.m25450d(TAG, "onDownstreamFormatChanged: " + Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13, Format format) {
        LogUtil.m25450d(TAG, "onDecoderInputFormatChanged: " + Format.toLogString(format));
        formatMediaInfo(OplusGLSurfaceView_13, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13, String str, long OplusGLSurfaceView_15) {
        LogUtil.m25450d(TAG, "onDecoderInitialized: decoderName = " + str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13, DecoderCounters decoderCounters) {
        LogUtil.m25450d(TAG, "onDecoderEnabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13, DecoderCounters decoderCounters) {
        LogUtil.m25450d(TAG, "onDecoderDisabled: " + LogUtil.getDecoderCountersString(decoderCounters));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        LogUtil.m25450d(TAG, "onRenderedFirstFrame: " + surface);
        if (!checkState() || this.hasRenderFirstFrame) {
            return;
        }
        this.firstRenderTime = System.currentTimeMillis() - this.startTimeMs;
        this.mReportBuilder = this.mReportBuilder.setRenderedFirstFrameTime(this.firstRenderTime);
        this.hasRenderFirstFrame = true;
        LogUtil.m25450d(TAG, "onRenderedFirstFrame: firstRenderTime[" + this.firstRenderTime + "]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int OplusGLSurfaceView_13) {
        LogUtil.m25450d(TAG, "onPlayerStateChanged: playWhenReady = " + z + ", state = " + LogUtil.getStateString(OplusGLSurfaceView_13));
        if (this.hasRenderFirstFrame) {
            if (z && OplusGLSurfaceView_13 == 2 && !this.rebuffering) {
                this.rebuffering = true;
                this.rebufferingStartTimeMs = System.currentTimeMillis();
            } else if (OplusGLSurfaceView_13 == 3 && this.rebuffering) {
                maybeAdvanceRebufferCount(true);
                this.rebuffering = false;
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        if (checkState()) {
            LogUtil.m25451d(TAG, "onPlayerError", exoPlaybackException);
            if (exoPlaybackException.type == 1) {
                updateErrorRendererInfo(exoPlaybackException);
            }
            this.mReportBuilder = this.mReportBuilder.setErrorCode(ErrorCodeProvider.parseException(this.mExoPlayer, exoPlaybackException)).setException(exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        MediaInfo mediaInfo;
        LogUtil.m25450d(TAG, "onTracksChanged");
        if (trackGroupArray != this.lastSeenTrackGroupArray) {
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
            if (currentMappedTrackInfo != null && (mediaInfo = this.mMediaInfo) != null) {
                mediaInfo.videoRendererSupport = getTrackTypeRendererSupport(currentMappedTrackInfo, 2);
                this.mMediaInfo.audioRendererSupport = getTrackTypeRendererSupport(currentMappedTrackInfo, 1);
            }
            this.lastSeenTrackGroupArray = trackGroupArray;
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        LogUtil.m25450d(TAG, "onLoadCompleted");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        LogUtil.m25450d(TAG, "onLoadCanceled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        LogUtil.m25450d(TAG, "onLoadError");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        LogUtil.m25450d(TAG, "onLoadingChanged: isLoading = " + z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
        LogUtil.m25450d(TAG, "onBandwidthEstimate: " + OplusGLSurfaceView_13 + ", " + OplusGLSurfaceView_15 + ", " + j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        LogUtil.m25450d(TAG, "onUpstreamDiscarded");
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int OplusGLSurfaceView_13) {
        if (z) {
            this.totalNetworkReadBytes += OplusGLSurfaceView_13;
        }
    }

    public synchronized void startSession(MediaUrl mediaUrl) {
        reset();
        this.mMediaUrl = mediaUrl;
        this.mMediaInfo = new MediaInfo(this.mMediaUrl.getUri().toString(), this.mMediaUrl.inferContentType());
        this.mReportBuilder = new Report.Builder();
        this.startTimeMs = System.currentTimeMillis();
        this.lastTimeStamp = this.startTimeMs;
        this.lastTotalRxBytes = NetSpeedUtil.getTotalRxBytes(LogUtil.getProcessUid());
        Pair<Long, Long> alreadyCacheBytes = TBLSourceManager.getAlreadyCacheBytes(this.mMediaUrl.getUri(), this.mMediaUrl.getCustomCacheKey());
        if (alreadyCacheBytes != null) {
            this.alreadyPreCacheBytes = ((Long) alreadyCacheBytes.first).longValue();
        }
        this.isStarted = true;
    }

    public synchronized Report endSession() {
        if (!checkState() || this.mReportBuilder == null) {
            return null;
        }
        maybeAdvanceRebufferCount(this.rebuffering);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.startTimeMs;
        Pair<Long, Long> alreadyCacheBytes = TBLSourceManager.getAlreadyCacheBytes(this.mMediaUrl.getUri(), this.mMediaUrl.getCustomCacheKey());
        if (alreadyCacheBytes != null) {
            this.mReportBuilder.setAlreadyCacheBytes(this.alreadyPreCacheBytes, ((Long) alreadyCacheBytes.second).longValue());
        }
        Report reportBuild = this.mReportBuilder.setAliveDuration(jCurrentTimeMillis).setMediaInfo(this.mMediaInfo).setRebufferCount(this.totalRebufferCount, this.totalRebufferTimeMs).setTotalNetworkReadBytes(this.totalNetworkReadBytes).setVideoFLR(getFrameLossRate(this.mExoPlayer.getVideoDecoderCounters())).setErrorRenderer(this.errorRendererInfo).build();
        reset();
        return reportBuild;
    }

    private void updateErrorRendererInfo(ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException.type == 1) {
            Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(this.mExoPlayer, Renderer[].class, "renderers");
            int OplusGLSurfaceView_13 = exoPlaybackException.rendererIndex;
            Renderer renderer = (OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_13 >= rendererArr.length) ? null : rendererArr[OplusGLSurfaceView_13];
            if (renderer != null) {
                if (renderer instanceof TBLMediaCodecVideoRenderer) {
                    this.errorRendererInfo = MediaInfo.RENDERER_TYPE_MC_VIDEO;
                    this.videoRendererHasFailed = true;
                    return;
                }
                if (renderer instanceof MediaCodecAudioRenderer) {
                    this.errorRendererInfo = MediaInfo.RENDERER_TYPE_MC_AUDIO;
                    this.audioRendererHasFailed = true;
                    return;
                }
                if (renderer instanceof FfmpegVideoRenderer) {
                    this.errorRendererInfo = MediaInfo.RENDERER_TYPE_FF_VIDEO;
                    return;
                }
                if (renderer instanceof FfmpegAudioRenderer) {
                    this.errorRendererInfo = MediaInfo.RENDERER_TYPE_FF_AUDIO;
                    return;
                }
                if (renderer instanceof TextRenderer) {
                    this.errorRendererInfo = MediaInfo.RENDERER_TYPE_TEXT;
                } else if (renderer instanceof MetadataRenderer) {
                    this.errorRendererInfo = MediaInfo.RENDERER_TYPE_METADATA;
                } else {
                    this.errorRendererInfo = MediaInfo.RENDERER_TYPE_UNKNOWN;
                }
            }
        }
    }

    private int getTrackTypeRendererSupport(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int OplusGLSurfaceView_13) {
        int typeSupport = mappedTrackInfo.getTypeSupport(OplusGLSurfaceView_13);
        if (typeSupport == 0) {
            return 1;
        }
        if (typeSupport == 1) {
            return 2;
        }
        if (typeSupport == 3 || typeSupport == 2) {
            Renderer[] rendererArr = (Renderer[]) ReflectUtil.getField(this.mExoPlayer, Renderer[].class, "renderers");
            if (!this.videoRendererHasFailed) {
                int i2 = 0;
                for (int i3 = 0; i3 < mappedTrackInfo.getRendererCount(); i3++) {
                    if (OplusGLSurfaceView_13 == mappedTrackInfo.getRendererType(i3) && (rendererArr[i3] instanceof MediaCodecRenderer)) {
                        i2 = mappedTrackInfo.getRendererSupport(i3) == 3 ? 3 : 5;
                    }
                }
                return i2;
            }
            MediaInfo mediaInfo = this.mMediaInfo;
            if (mediaInfo != null) {
                mediaInfo.videoRendererSupport = 4;
            }
        }
        return 0;
    }

    public void maybeAdvanceRebufferCount(boolean z) {
        if (z) {
            LogUtil.m25450d(TAG, "maybeAdvanceRebufferCount");
            this.totalRebufferCount++;
            this.totalRebufferTimeMs += System.currentTimeMillis() - this.rebufferingStartTimeMs;
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
        this.errorRendererInfo = MediaInfo.RENDERER_TYPE_NONE;
    }

    public boolean checkState() {
        return this.isStarted;
    }

    public MediaInfo getMediaInfo() {
        return this.mMediaInfo;
    }

    public long getNetSpeed(int OplusGLSurfaceView_13) {
        if (!checkState()) {
            return 0L;
        }
        long totalRxBytes = NetSpeedUtil.getTotalRxBytes(OplusGLSurfaceView_13);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long OplusGLSurfaceView_15 = jCurrentTimeMillis - this.lastTimeStamp;
        if (OplusGLSurfaceView_15 <= 0) {
            return 0L;
        }
        long j2 = ((totalRxBytes - this.lastTotalRxBytes) * 1000) / OplusGLSurfaceView_15;
        this.lastTimeStamp = jCurrentTimeMillis;
        this.lastTotalRxBytes = totalRxBytes;
        return j2;
    }

    public void formatMediaInfo(int OplusGLSurfaceView_13, Format format) {
        MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo != null) {
            if (OplusGLSurfaceView_13 == 1) {
                mediaInfo.audioSampleRate = format.sampleRate;
                this.mMediaInfo.audioMimeType = format.sampleMimeType;
            } else if (OplusGLSurfaceView_13 == 2) {
                mediaInfo.width = format.width;
                this.mMediaInfo.height = format.height;
                this.mMediaInfo.videoMimeType = format.sampleMimeType;
                this.mMediaInfo.videoFps = format.frameRate;
            }
        }
    }

    public static float getFrameLossRate(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return 0.0f;
        }
        try {
            decoderCounters.ensureUpdated();
            LogUtil.m25450d(TAG, "VideoDecoderCounters: " + LogUtil.getDecoderCountersString(decoderCounters));
            return ((long) decoderCounters.droppedBufferCount) / (decoderCounters.renderedOutputBufferCount + r1);
        } catch (Exception unused) {
            return 0.0f;
        }
    }
}
