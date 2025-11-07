package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public final class TBLRetryPlayer extends com.oplus.tblplayer.TBLExoPlayer {
    private static final int RETRY_WITH_FFMPEG_CDOEC = 1;
    private static final int RETRY_WITH_NONE = 0;
    private static java.lang.String TAG = "TBLRetryPlayer";
    private boolean maybeRetry;
    private boolean playWhenReady;
    private int repeatMode;
    private int retryCount;
    private android.view.Surface surface;
    private float volume;

    static /* synthetic */ int access$308(com.oplus.tblplayer.TBLRetryPlayer tBLRetryPlayer) {
        int i_renamed = tBLRetryPlayer.retryCount;
        tBLRetryPlayer.retryCount = i_renamed + 1;
        return i_renamed;
    }

    public TBLRetryPlayer(android.content.Context context) {
        super(context);
        this.retryCount = 0;
    }

    public TBLRetryPlayer(android.content.Context context, int i_renamed) {
        super(context, i_renamed);
        this.retryCount = 0;
    }

    public TBLRetryPlayer(android.content.Context context, int i_renamed, int i2) {
        super(context, i_renamed, i2);
        this.retryCount = 0;
    }

    @Override // com.oplus.tblplayer.TBLExoPlayer
    protected com.google.android.exoplayer2.SimpleExoPlayer createInternalPlayer() {
        return super.createInternalPlayer();
    }

    @Override // com.oplus.tblplayer.TBLExoPlayer
    protected void attachAnalyticsListener() {
        this.mInnerListener = new com.oplus.tblplayer.TBLRetryPlayer.InnerRetryListener();
        this.mInternalPlayer.addAnalyticsListener(this.mInnerListener);
        this.mLoadControl.addEventListener(this.mEventHandler, this.mInnerListener);
    }

    private class InnerRetryListener extends com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener {
        private InnerRetryListener() {
            super();
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onRenderedFirstFrame(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, android.view.Surface surface) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLRetryPlayer.TAG, "onRenderedFirstFrame: maybeRetry is_renamed " + com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry + ", preparing is_renamed " + com.oplus.tblplayer.TBLRetryPlayer.this.mIsPreparing);
            if (com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry) {
                return;
            }
            if (com.oplus.tblplayer.TBLRetryPlayer.this.mIsPreparing) {
                com.oplus.tblplayer.TBLRetryPlayer.this.retryCount = 0;
                com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry = false;
            }
            super.onRenderedFirstFrame(eventTime, surface);
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed, int i_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLRetryPlayer.TAG, "onPlayerStateChanged: maybeRetry is_renamed " + com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry + ", playWhenReady is_renamed " + z_renamed + ", playbackState is_renamed " + com.oplus.tblplayer.utils.LogUtil.getStateString(i_renamed));
            if (com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry) {
                return;
            }
            super.onPlayerStateChanged(eventTime, z_renamed, i_renamed);
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPositionDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLRetryPlayer.TAG, "onPositionDiscontinuity: maybeRetry is_renamed " + com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry + ", reason is_renamed " + com.oplus.tblplayer.utils.LogUtil.getDiscontinuityReasonString(i_renamed));
            if (com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry) {
                return;
            }
            super.onPositionDiscontinuity(eventTime, i_renamed);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onLoadError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLRetryPlayer.TAG, "onLoadError: " + iOException);
            if (iOException instanceof com.google.android.exoplayer2.ParserException) {
                com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry = true;
            } else if ((iOException instanceof com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException) && !(iOException.getCause() instanceof java.lang.OutOfMemoryError)) {
                com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry = true;
            }
            if (com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetryStartPlayer(1)) {
                com.oplus.tblplayer.TBLRetryPlayer.this.showToast("Load error. will retry!!!");
            } else {
                super.onLoadError(eventTime, loadEventInfo, mediaLoadData, iOException, z_renamed);
            }
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLRetryPlayer.TAG, "onPlayerError: type = " + exoPlaybackException.type, exoPlaybackException);
            java.lang.Throwable cause = exoPlaybackException.getCause();
            int i_renamed = exoPlaybackException.type;
            if ((cause instanceof com.oplus.tblplayer.ffmpeg.DecoderException) || (cause instanceof com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException)) {
                com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry = true;
            } else if (((cause instanceof java.lang.IllegalStateException) && i_renamed == 1) || (cause instanceof com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException)) {
                com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry = true;
            } else if (cause instanceof com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException) {
                com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetry = true;
                com.oplus.tblplayer.TBLRetryPlayer.access$308(com.oplus.tblplayer.TBLRetryPlayer.this);
            }
            if (com.oplus.tblplayer.TBLRetryPlayer.this.maybeRetryStartPlayer(1)) {
                com.oplus.tblplayer.TBLRetryPlayer.this.showToast("Player error. will retry!!!");
            } else {
                super.onPlayerError(eventTime, exoPlaybackException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(java.lang.String str) {
        com.oplus.tblplayer.utils.LogUtil.w_renamed(TAG, "Should show message is_renamed " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRetryStartPlayer(int i_renamed) {
        if (!this.maybeRetry || this.retryCount >= 2 || i_renamed <= 0) {
            return false;
        }
        if (i_renamed == 1) {
            this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.TBLRetryPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.tblplayer.TBLRetryPlayer.this.retryPlayerAfterError();
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryPlayerAfterError() {
        if (this.mInternalPlayer == null) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "retryPlayer canceled for player is_renamed released");
            return;
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "retryPlayerAfterError");
        savePlayerState();
        this.mInternalPlayer.removeAnalyticsListener(this.mInnerListener);
        this.mInternalPlayer.removeAnalyticsListener(this.mMonitor);
        this.mInternalPlayer.stop(true);
        this.maybeRetry = false;
        this.retryCount++;
        this.mRenderersFactory = new com.oplus.tblplayer.render.TBLRenderersFactory(this.mAppContext, 2);
        this.mInternalPlayer = com.google.android.exoplayer2.ExoPlayerFactory.newSimpleInstance(this.mAppContext, this.mRenderersFactory, this.mTrackSelector, this.mLoadControl);
        this.mInternalPlayer.addAnalyticsListener(this.mInnerListener);
        this.mInternalPlayer.addAnalyticsListener(this.mMonitor);
        resumePlayer();
    }

    private void savePlayerState() {
        if (this.mInternalPlayer == null) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "savePlayerState failed, player is_renamed null !");
            return;
        }
        this.surface = getInternalSurface();
        this.playWhenReady = this.mInternalPlayer.getPlayWhenReady();
        this.repeatMode = this.mInternalPlayer.getRepeatMode();
        this.volume = this.mInternalPlayer.getVolume();
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "retryPlayerAfterError: surface = " + this.surface);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "retryPlayerAfterError: playWhenReady = " + this.playWhenReady);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "retryPlayerAfterError: repeatMode = " + this.repeatMode);
    }

    private void resumePlayer() {
        this.mInternalPlayer.setVideoSurface(this.surface);
        this.mInternalPlayer.setPlayWhenReady(this.playWhenReady);
        this.mInternalPlayer.setVolume(this.volume);
        this.mInternalPlayer.setRepeatMode(this.repeatMode);
        this.mInternalPlayer.prepare(this.mediaSource);
    }

    public android.view.Surface getInternalSurface() {
        if (this.mInternalPlayer != null && (this.mInternalPlayer instanceof com.google.android.exoplayer2.SimpleExoPlayer)) {
            return (android.view.Surface) com.oplus.tblplayer.utils.ReflectUtil.getField(this.mInternalPlayer, android.view.Surface.class, "surface");
        }
        return null;
    }
}
