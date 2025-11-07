package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public class TBLExoPlayer extends com.oplus.tblplayer.AbstractMediaPlayer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static java.lang.String TAG = "TBLExoPlayer";
    protected int extractorType;
    private java.util.List<com.oplus.tblplayer.render.FallbackRenderer> fallbackRenderers;
    protected boolean hasComplete;
    protected boolean hasRelease;
    protected android.content.Context mAppContext;
    protected android.os.Handler mEventHandler;
    protected com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener mInnerListener;
    protected com.google.android.exoplayer2.SimpleExoPlayer mInternalPlayer;
    protected boolean mIsBuffering;
    protected boolean mIsPreparing;
    protected com.oplus.tblplayer.TBLLoadControl mLoadControl;
    protected com.oplus.tblplayer.misc.MediaUrl mMediaUrl;
    protected com.oplus.tblplayer.monitor.AnalyticsMonitor mMonitor;
    protected boolean mOldIsPlaying;
    protected com.google.android.exoplayer2.DefaultRenderersFactory mRenderersFactory;
    protected com.oplus.tblplayer.managers.SlowMotionManager mSlowMotion;
    protected com.google.android.exoplayer2.trackselection.DefaultTrackSelector mTrackSelector;
    protected int mVideoHeight;
    protected int mVideoWidth;
    protected com.google.android.exoplayer2.source.MediaSource mediaSource;
    protected int rendererType;
    private java.util.List<com.oplus.tblplayer.render.RollupRenderer> rollupRenderers;

    @Override // com.oplus.tblplayer.IMediaPlayer
    public com.oplus.tblplayer.misc.ITrackInfo[] getTrackInfo() {
        return null;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioStreamType(int i_renamed) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setKeepInBackground(boolean z_renamed) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLogEnabled(boolean z_renamed) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z_renamed) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setWakeMode(int i_renamed) {
    }

    public TBLExoPlayer(android.content.Context context) {
        this(context, 0);
    }

    public TBLExoPlayer(android.content.Context context, int i_renamed) {
        this(context, i_renamed, 0);
    }

    public TBLExoPlayer(android.content.Context context, int i_renamed, int i2) {
        this.mMediaUrl = null;
        this.mediaSource = null;
        this.mIsPreparing = false;
        this.mIsBuffering = false;
        this.hasComplete = false;
        this.hasRelease = false;
        this.mOldIsPlaying = false;
        this.mSlowMotion = null;
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "TBLExoPlayer: create");
        this.mAppContext = context.getApplicationContext();
        this.mEventHandler = new android.os.Handler(getLooper());
        this.rendererType = i_renamed;
        this.extractorType = i2;
        com.google.android.exoplayer2.util.TraceUtil.beginSection("TBLExoPlayer.createPlayer");
        this.mInternalPlayer = createInternalPlayer();
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        java.lang.String str = TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Create internal player success: ");
        sb.append(this.mInternalPlayer != null);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(str, sb.toString());
        attachAnalyticsListener();
        this.mMonitor = new com.oplus.tblplayer.monitor.AnalyticsMonitor(this.mInternalPlayer, this.mTrackSelector);
        this.mInternalPlayer.addAnalyticsListener(this.mMonitor);
        this.fallbackRenderers = new java.util.ArrayList(2);
        this.rollupRenderers = new java.util.ArrayList(2);
    }

    protected android.os.Looper getLooper() {
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : android.os.Looper.getMainLooper();
    }

    protected com.google.android.exoplayer2.SimpleExoPlayer createInternalPlayer() {
        if (this.mTrackSelector == null) {
            this.mTrackSelector = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector(new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory());
        }
        if (this.mRenderersFactory == null) {
            this.mRenderersFactory = new com.oplus.tblplayer.render.TBLRenderersFactory(this.mAppContext, this.rendererType);
        }
        if (this.mLoadControl == null) {
            this.mLoadControl = new com.oplus.tblplayer.TBLLoadControl();
        }
        return com.google.android.exoplayer2.ExoPlayerFactory.newSimpleInstance(this.mAppContext, this.mRenderersFactory, this.mTrackSelector, this.mLoadControl);
    }

    protected void attachAnalyticsListener() {
        this.mInnerListener = new com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener();
        this.mInternalPlayer.addAnalyticsListener(this.mInnerListener);
        this.mLoadControl.addEventListener(this.mEventHandler, this.mInnerListener);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setNetworkType(int i_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setNetworkType: networkType is_renamed " + i_renamed);
        updateNetworkType(i_renamed);
    }

    public void updateNetworkType(int i_renamed) {
        com.oplus.tblplayer.TBLLoadControl tBLLoadControl;
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null || (tBLLoadControl = this.mLoadControl) == null) {
            return;
        }
        simpleExoPlayer.createMessage(tBLLoadControl).setType(1).setPayload(java.lang.Integer.valueOf(i_renamed)).send();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVsyncOffsetPercentage(int i_renamed) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVsyncOffsetPercentage(i_renamed);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setMediaFormatAttr(java.util.HashMap<java.lang.String, java.lang.Integer> map) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setMediaFormatAttr(map);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getBufferForPlaybackMs() {
        com.oplus.tblplayer.TBLLoadControl tBLLoadControl;
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "getBufferForPlaybackMs");
        if (this.mInternalPlayer == null || (tBLLoadControl = this.mLoadControl) == null) {
            return 0L;
        }
        return com.google.android.exoplayer2.C_renamed.usToMs(tBLLoadControl.getLoadPolicy().bufferForPlaybackUs);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setDisplay");
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoSurfaceView(android.view.SurfaceView surfaceView) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setVideoSurfaceView");
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurfaceView(android.view.SurfaceView surfaceView) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "clearVideoSurfaceView");
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.clearVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoTextureView(android.view.TextureView textureView) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setVideoTextureView");
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoTextureView(android.view.TextureView textureView) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "clearVideoTextureView");
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.clearVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSurface(android.view.Surface surface) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setSurface: surface is_renamed " + surface);
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurface(surface);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoScalingMode(int i_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setVideoScalingMode: mode is_renamed " + i_renamed);
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoScalingMode(i_renamed);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        setMediaUrlInternal((com.oplus.tblplayer.misc.MediaUrl) com.oplus.tblplayer.utils.AssertUtil.checkNotNull(mediaUrl));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(java.lang.String str) {
        setDataSource(android.net.Uri.parse(str));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(java.io.FileDescriptor fileDescriptor) {
        throw new java.lang.UnsupportedOperationException("no support");
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(android.net.Uri uri) {
        setMediaUrlInternal(new com.oplus.tblplayer.misc.MediaUrl.Builder(uri).build());
    }

    protected synchronized void setMediaUrlInternal(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setDataSource: uri is_renamed " + mediaUrl);
        boolean z_renamed = true;
        if (this.mInternalPlayer == null || this.mInternalPlayer.getPlaybackState() != 1) {
            z_renamed = false;
        }
        com.oplus.tblplayer.utils.AssertUtil.checkState(z_renamed);
        this.mMediaUrl = (com.oplus.tblplayer.misc.MediaUrl) com.oplus.tblplayer.utils.AssertUtil.checkNotNull(mediaUrl);
        this.mediaSource = com.oplus.tblplayer.managers.TBLSourceManager.buildMediaSource(buildDataSourceFactory(this.mMediaUrl), this.mMediaUrl, this.extractorType);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) {
        setMediaUrlInternal(new com.oplus.tblplayer.misc.MediaUrl.Builder(uri).setHeaders(map).build());
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public java.lang.String getDataSource() {
        if (this.mInternalPlayer == null) {
            throw new java.lang.IllegalStateException("Internal player is_renamed null.");
        }
        com.oplus.tblplayer.misc.MediaUrl mediaUrl = this.mMediaUrl;
        if (mediaUrl == null || mediaUrl.getUri() == null) {
            return null;
        }
        return this.mMediaUrl.getUri().toString();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setClippingTimeline(long j_renamed, long j2) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null || this.mediaSource == null) {
            throw new java.lang.IllegalStateException("Not set data source.");
        }
        if (simpleExoPlayer.getPlaybackState() != 1) {
            throw new java.lang.IllegalStateException("Player is_renamed not idle state.");
        }
        if (!(this.mediaSource instanceof com.google.android.exoplayer2.source.ExtractorMediaSource)) {
            throw new java.lang.IllegalArgumentException("Not a_renamed single-period source.");
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setClippingTimeline: startUs is_renamed " + j_renamed + ", endUs is_renamed " + j2);
        this.mediaSource = new com.google.android.exoplayer2.source.ClippingMediaSource(this.mediaSource, j_renamed, j2);
    }

    private void setTrackRendererDisable(int i_renamed) {
        for (int i2 = 0; i2 < this.mInternalPlayer.getRendererCount(); i2++) {
            if (this.mInternalPlayer.getRendererType(i2) == i_renamed) {
                com.google.android.exoplayer2.trackselection.DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
                defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setRendererDisabled(i2, true).build());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void prepareAsync() throws java.lang.IllegalStateException {
        if (this.mInternalPlayer.getPlaybackState() >= 3) {
            com.oplus.tblplayer.utils.LogUtil.w_renamed(TAG, "prepareAsync: it is_renamed preload player, had prepared!");
            notifyOnInfo(702, this.mInternalPlayer.getBufferedPercentage());
            notifyOnPrepared();
            this.mIsPreparing = false;
            return;
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "prepareAsync: do  prepare");
        this.mIsPreparing = true;
        this.mOldIsPlaying = false;
        this.mMonitor.startSession(this.mMediaUrl);
        maybeResetFallbackRollupRenderers();
        this.mInternalPlayer.setPlayWhenReady(false);
        com.google.android.exoplayer2.util.TraceUtil.beginSection("TBLExoPlayer.prepareAsync");
        this.mInternalPlayer.prepare(this.mediaSource);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void start() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, com.google.android.exoplayer2.text.ttml.TtmlNode.START);
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        com.google.android.exoplayer2.util.TraceUtil.beginSection("TBLExoPlayer.start");
        this.mInternalPlayer.setPlayWhenReady(true);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void stop() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "stop");
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        this.mInternalPlayer.stop();
        com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            slowMotionManager.stop();
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void pause() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, com.oplus.camera.statistics.model.VideoRecordMsgData.EVENT_PAUSE);
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        this.mInternalPlayer.setPlayWhenReady(false);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void reset() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "reset");
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop(true);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void release() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "release");
        maybeNotifyPlaybackReport();
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            this.mInternalPlayer.removeAnalyticsListener(this.mInnerListener);
            this.mInternalPlayer.removeAnalyticsListener(this.mMonitor);
            this.mInternalPlayer = null;
            this.mMonitor = null;
            this.mMediaUrl = null;
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
            this.mIsPreparing = false;
            this.mIsBuffering = false;
            this.hasComplete = false;
            this.hasRelease = true;
            java.util.List<com.oplus.tblplayer.render.FallbackRenderer> list = this.fallbackRenderers;
            if (list != null) {
                list.clear();
                this.fallbackRenderers = null;
            }
            java.util.List<com.oplus.tblplayer.render.RollupRenderer> list2 = this.rollupRenderers;
            if (list2 != null) {
                list2.clear();
                this.rollupRenderers = null;
            }
            com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = this.mSlowMotion;
            if (slowMotionManager != null) {
                slowMotionManager.stop();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlaying() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        return simpleExoPlayer != null && simpleExoPlayer.getPlaybackState() == 3 && this.mInternalPlayer.getPlayWhenReady();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPause() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return false;
        }
        int playbackState = simpleExoPlayer.getPlaybackState();
        if (this.mInternalPlayer.getPlayWhenReady()) {
            return false;
        }
        return playbackState == 3 || playbackState == 2;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isStop() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        return simpleExoPlayer == null || simpleExoPlayer.getPlaybackState() == 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaybackState() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 1;
        }
        return simpleExoPlayer.getPlaybackState();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setSeekParameters: " + seekParameters);
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setSeekParameters(seekParameters);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void seekTo(long j_renamed) throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "seekTo: msec is_renamed " + j_renamed);
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            j_renamed = slowMotionManager.adaptPosition(j_renamed, true);
        }
        simpleExoPlayer.seekTo(j_renamed);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void fastSeekTo(long j_renamed, boolean z_renamed) throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "fastSeekTo: msec is_renamed " + j_renamed);
        if (this.mInternalPlayer == null) {
            return;
        }
        com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            j_renamed = slowMotionManager.adaptPosition(j_renamed, true);
        }
        this.mInternalPlayer.fastSeekTo(j_renamed, z_renamed);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setPlaybackRate(float f_renamed) {
        com.google.android.exoplayer2.PlaybackParameters playbackParameters = new com.google.android.exoplayer2.PlaybackParameters(f_renamed);
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlaybackParameters(playbackParameters);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getCurrentPosition() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long currentPosition = simpleExoPlayer.getCurrentPosition();
        com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(currentPosition, false) : currentPosition;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getDuration() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long duration = simpleExoPlayer.getDuration();
        com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(duration, false) : duration;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getSpeed() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0.0f;
        }
        return simpleExoPlayer.getPlaybackParameters().speed;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVolume(float f_renamed) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setVolume(f_renamed);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLooping(boolean z_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setLooping: looping is_renamed " + z_renamed);
        if (z_renamed) {
            this.mInternalPlayer.setRepeatMode(1);
        } else {
            this.mInternalPlayer.setRepeatMode(0);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isLooping() {
        return this.mInternalPlayer.getRepeatMode() != 0;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getAudioSessionId() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0;
        }
        return simpleExoPlayer.getAudioSessionId();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public com.oplus.tblplayer.misc.MediaInfo getMediaInfo() {
        com.oplus.tblplayer.monitor.AnalyticsMonitor analyticsMonitor = this.mMonitor;
        if (analyticsMonitor == null || !analyticsMonitor.checkState()) {
            return null;
        }
        return this.mMonitor.getMediaInfo();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getNetSpeed() {
        com.oplus.tblplayer.monitor.AnalyticsMonitor analyticsMonitor;
        if (this.mInternalPlayer == null || (analyticsMonitor = this.mMonitor) == null) {
            return 0L;
        }
        return analyticsMonitor.getNetSpeed(this.mAppContext.getApplicationInfo().uid);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getContentBufferedPosition() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long contentBufferedPosition = simpleExoPlayer.getContentBufferedPosition();
        com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(contentBufferedPosition, false) : contentBufferedPosition;
    }

    public int getBufferedPercentage() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0;
        }
        if (this.mSlowMotion != null) {
            long contentBufferedPosition = getContentBufferedPosition();
            long duration = getDuration();
            if (contentBufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
                return 0;
            }
            if (duration == 0) {
                return 100;
            }
            return com.google.android.exoplayer2.util.Util.constrainValue((int) ((contentBufferedPosition * 100) / duration), 0, 100);
        }
        return simpleExoPlayer.getBufferedPercentage();
    }

    protected class InnerAnalyticsListener implements com.google.android.exoplayer2.analytics.AnalyticsListener, com.oplus.tblplayer.TBLLoadControl.EventListener {
        protected InnerAnalyticsListener() {
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onDecoderInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.Format format) {
            com.oplus.tblplayer.TBLExoPlayer.this.maybeNotifyHdrInfo(i_renamed, format);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onDownstreamFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            if (mediaLoadData.trackType == 2) {
                com.oplus.tblplayer.TBLExoPlayer.this.mVideoHeight = mediaLoadData.trackFormat.height;
                com.oplus.tblplayer.TBLExoPlayer.this.mVideoWidth = mediaLoadData.trackFormat.width;
                int i_renamed = mediaLoadData.trackFormat.rotationDegrees;
                float f_renamed = mediaLoadData.trackFormat.pixelWidthHeightRatio;
                com.oplus.tblplayer.utils.LogUtil.dfmt(com.oplus.tblplayer.TBLExoPlayer.TAG, "notifyOnDownstreamSizeChanged: [%d_renamed, %d_renamed, %d_renamed, %f_renamed]", java.lang.Integer.valueOf(com.oplus.tblplayer.TBLExoPlayer.this.mVideoWidth), java.lang.Integer.valueOf(com.oplus.tblplayer.TBLExoPlayer.this.mVideoHeight), java.lang.Integer.valueOf(i_renamed), java.lang.Float.valueOf(f_renamed));
                com.oplus.tblplayer.TBLExoPlayer tBLExoPlayer = com.oplus.tblplayer.TBLExoPlayer.this;
                tBLExoPlayer.notifyOnDownstreamSizeChanged(tBLExoPlayer.mVideoWidth, com.oplus.tblplayer.TBLExoPlayer.this.mVideoHeight, i_renamed, f_renamed);
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onVideoSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, int i2, int i3, float f_renamed) {
            com.oplus.tblplayer.TBLExoPlayer tBLExoPlayer = com.oplus.tblplayer.TBLExoPlayer.this;
            tBLExoPlayer.mVideoWidth = i_renamed;
            tBLExoPlayer.mVideoHeight = i2;
            com.oplus.tblplayer.utils.LogUtil.dfmt(com.oplus.tblplayer.TBLExoPlayer.TAG, "onVideoSizeChanged: [%d_renamed, %d_renamed, %d_renamed, %f_renamed]", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Float.valueOf(f_renamed));
            com.oplus.tblplayer.TBLExoPlayer.this.notifyOnVideoSizeChanged(i_renamed, i2, i3, f_renamed);
            if (i3 > 0) {
                com.oplus.tblplayer.TBLExoPlayer.this.notifyOnInfo(10001, i3);
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onRenderedFirstFrame(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, android.view.Surface surface) {
            if (com.oplus.tblplayer.TBLExoPlayer.this.mIsPreparing) {
                com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLExoPlayer.TAG, "onRenderedFirstFrame: will notifyOnPrepared");
                com.oplus.tblplayer.TBLExoPlayer.this.maybeInitializeSlowMotion();
                com.oplus.tblplayer.TBLExoPlayer.this.notifyOnPrepared();
                com.oplus.tblplayer.TBLExoPlayer.this.mIsPreparing = false;
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed, int i_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLExoPlayer.TAG, "onPlayerStateChanged: playWhenReady is_renamed " + z_renamed + ", " + com.oplus.tblplayer.utils.LogUtil.getStateString(i_renamed));
            com.oplus.tblplayer.TBLExoPlayer.this.notifyOnPlayerStateChanged(i_renamed);
            com.oplus.tblplayer.TBLExoPlayer.this.maybeNotifyBuffingInfo(z_renamed, i_renamed);
            com.oplus.tblplayer.TBLExoPlayer.this.maybeNotifyPlayingChanged(z_renamed, i_renamed);
            com.oplus.tblplayer.TBLExoPlayer.this.maybeNotifyPlaybackCompletion(z_renamed, i_renamed);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
            if (com.oplus.tblplayer.TBLExoPlayer.this.maybeRetryWithBackupSource()) {
                return;
            }
            if (com.oplus.tblplayer.TBLExoPlayer.this.maybeRetryWithFallbackRollupRenderer(exoPlaybackException)) {
                com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLExoPlayer.TAG, "onPlayerError: will retry player with disable error renderer.");
            } else {
                com.oplus.tblplayer.TBLExoPlayer.this.notifyOnError(exoPlaybackException.type, com.oplus.tblplayer.monitor.ErrorCodeProvider.parseException(com.oplus.tblplayer.TBLExoPlayer.this.mInternalPlayer, exoPlaybackException), exoPlaybackException.getMessage());
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPositionDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLExoPlayer.TAG, "onPositionDiscontinuity: " + com.oplus.tblplayer.utils.LogUtil.getDiscontinuityReasonString(i_renamed));
            if (com.oplus.tblplayer.TBLExoPlayer.this.isLooping() && i_renamed == 0) {
                com.oplus.tblplayer.TBLExoPlayer.this.notifyOnInfo(5, 0);
            }
        }

        @Override // com.oplus.tblplayer.TBLLoadControl.EventListener
        public void onBufferPercentChanged(int i_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLExoPlayer.TAG, "onBufferPercentChanged: percent is_renamed " + i_renamed);
            com.oplus.tblplayer.TBLExoPlayer.this.notifyOnBufferingUpdate(i_renamed);
        }

        @Override // com.oplus.tblplayer.TBLLoadControl.EventListener
        public void onLoadControlStateChanged(int i_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(com.oplus.tblplayer.TBLExoPlayer.TAG, "onLoadControlStateChanged: state is_renamed " + i_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRetryWithBackupSource() {
        com.oplus.tblplayer.misc.MediaUrl mediaUrl;
        if (this.hasRelease || (mediaUrl = this.mMediaUrl) == null || !mediaUrl.hasNextBackupSource()) {
            return false;
        }
        com.oplus.tblplayer.misc.MediaUrl mediaUrlNextBackupSource = this.mMediaUrl.nextBackupSource();
        this.mInternalPlayer.prepare(com.oplus.tblplayer.managers.TBLSourceManager.buildMediaSource(buildDataSourceFactory(mediaUrlNextBackupSource), mediaUrlNextBackupSource, this.extractorType), false, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeInitializeSlowMotion() {
        if (com.oplus.tblplayer.utils.CommonUtil.isSlowMotionHsr(this.mMediaUrl.getOverrideExtension())) {
            this.mSlowMotion = com.oplus.tblplayer.managers.SlowMotionManager.create(this.mAppContext, this, this.mMediaUrl.getOverrideExtension(), this.mInternalPlayer.getVideoFormat().frameRate, 30, this.mInternalPlayer.getDuration());
            if (this.mSlowMotion != null) {
                setTrackRendererDisable(1);
                this.mSlowMotion.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRetryWithFallbackRollupRenderer(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        com.google.android.exoplayer2.Renderer[] rendererArr;
        com.google.android.exoplayer2.Renderer[] rendererArr2;
        java.lang.Throwable cause = exoPlaybackException.getCause();
        int i_renamed = exoPlaybackException.rendererIndex;
        if (this.hasRelease || this.fallbackRenderers == null || this.rollupRenderers == null || this.rendererType != 0 || (exoPlaybackException.getCause() instanceof com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer.VideoOverSpecificationException)) {
            return false;
        }
        if (exoPlaybackException.type == 1 && (rendererArr2 = (com.google.android.exoplayer2.Renderer[]) com.oplus.tblplayer.utils.ReflectUtil.getField(this.mInternalPlayer, com.google.android.exoplayer2.Renderer[].class, "renderers")) != null && i_renamed >= 0 && i_renamed < rendererArr2.length) {
            com.google.android.exoplayer2.Renderer renderer = rendererArr2[i_renamed];
            if (renderer instanceof com.oplus.tblplayer.render.FallbackRenderer) {
                if ((renderer instanceof com.oplus.tblplayer.render.RollupRenderer) && ((com.oplus.tblplayer.render.RollupRenderer) renderer).isRollup()) {
                    com.oplus.tblplayer.utils.LogUtil.w_renamed(TAG, "maybeRetryWithFallbackRollupRenderer: already tried ffmpeg audio decoder,exit");
                    return false;
                }
                com.oplus.tblplayer.utils.LogUtil.w_renamed(TAG, "maybeRetryWithFallbackRollupRenderer: will fallback renderer: " + renderer.getClass().getSimpleName(), cause);
                com.oplus.tblplayer.render.FallbackRenderer fallbackRenderer = (com.oplus.tblplayer.render.FallbackRenderer) renderer;
                fallbackRenderer.setFallbackRenderer(true);
                this.fallbackRenderers.add(fallbackRenderer);
                this.mInternalPlayer.retry();
                return true;
            }
        }
        if (exoPlaybackException.type == 1 && exoPlaybackException.toString().contains("FfmpegAudioDecoderException") && (rendererArr = (com.google.android.exoplayer2.Renderer[]) com.oplus.tblplayer.utils.ReflectUtil.getField(this.mInternalPlayer, com.google.android.exoplayer2.Renderer[].class, "renderers")) != null) {
            for (com.google.android.exoplayer2.Renderer renderer2 : rendererArr) {
                if (renderer2 instanceof com.oplus.tblplayer.render.RollupRenderer) {
                    com.oplus.tblplayer.utils.LogUtil.w_renamed(TAG, "maybeRetryWithFallbackRollupRenderer: will rollup renderer: " + renderer2.getClass().getSimpleName());
                    com.oplus.tblplayer.render.RollupRenderer rollupRenderer = (com.oplus.tblplayer.render.RollupRenderer) renderer2;
                    rollupRenderer.setRollupRenderer(true);
                    this.rollupRenderers.add(rollupRenderer);
                    this.mInternalPlayer.retry();
                    return true;
                }
            }
        }
        return false;
    }

    private synchronized void maybeResetFallbackRollupRenderers() {
        if (this.fallbackRenderers != null && !this.fallbackRenderers.isEmpty()) {
            java.util.Iterator<com.oplus.tblplayer.render.FallbackRenderer> it = this.fallbackRenderers.iterator();
            while (it.hasNext()) {
                it.next().setFallbackRenderer(false);
            }
            this.fallbackRenderers.clear();
        }
        if (this.rollupRenderers != null && !this.rollupRenderers.isEmpty()) {
            java.util.Iterator<com.oplus.tblplayer.render.RollupRenderer> it2 = this.rollupRenderers.iterator();
            while (it2.hasNext()) {
                it2.next().setRollupRenderer(false);
            }
            this.rollupRenderers.clear();
        }
    }

    private void maybeNotifyPlaybackReport() {
        com.oplus.tblplayer.monitor.AnalyticsMonitor analyticsMonitor = this.mMonitor;
        if (analyticsMonitor == null || !analyticsMonitor.checkState()) {
            return;
        }
        com.oplus.tblplayer.monitor.Report reportEndSession = this.mMonitor.endSession();
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "notifyPlaybackReport: " + reportEndSession);
        if (reportEndSession != null) {
            notifyOnPlaybackResult(reportEndSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyBuffingInfo(boolean z_renamed, int i_renamed) {
        if (!this.mIsBuffering) {
            if (i_renamed == 2) {
                notifyOnInfo(701, this.mInternalPlayer.getBufferedPercentage());
                this.mIsBuffering = true;
                return;
            }
            return;
        }
        if (i_renamed == 3 || i_renamed == 4) {
            notifyOnInfo(702, this.mInternalPlayer.getBufferedPercentage());
            this.mIsBuffering = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyPlayingChanged(boolean z_renamed, int i_renamed) {
        boolean zIsPlaying = isPlaying();
        if (this.mOldIsPlaying != zIsPlaying) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "notifyOnIsPlayingChanged: isPlaying is_renamed " + zIsPlaying);
            notifyOnIsPlayingChanged(zIsPlaying);
            this.mOldIsPlaying = zIsPlaying;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyHdrInfo(int i_renamed, com.google.android.exoplayer2.Format format) {
        if (i_renamed != 2 || !this.mIsPreparing || format == null || format.colorInfo == null) {
            return;
        }
        if (format.colorInfo.colorTransfer == 6 || format.colorInfo.colorTransfer == 7) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "maybeNotifyHdrInfo: " + format.colorInfo);
            notifyOnInfo(4, format.colorInfo.colorTransfer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyPlaybackCompletion(boolean z_renamed, int i_renamed) {
        if (i_renamed != 2 && i_renamed != 3) {
            if (i_renamed == 4 && !this.hasComplete) {
                if (z_renamed) {
                    this.mInternalPlayer.setPlayWhenReady(false);
                }
                com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "STATE_ENDED will callback completion.");
                maybeNotifyPlaybackReport();
                notifyOnCompletion();
                this.hasComplete = true;
                return;
            }
            return;
        }
        if (this.hasComplete) {
            this.hasComplete = false;
        }
    }

    public com.google.android.exoplayer2.upstream.DataSource.Factory buildDataSourceFactory(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        com.google.android.exoplayer2.upstream.HttpDataSource.Factory factoryBuildHttpDataSourceFactory;
        if (com.oplus.tblplayer.config.Globals.getOkhttpEnable()) {
            factoryBuildHttpDataSourceFactory = com.oplus.tblplayer.managers.TBLSourceManager.buildOkHttpDataSourceFactory(com.oplus.tblplayer.config.Globals.getUserAgent(), com.oplus.tblplayer.config.Globals.getOkhttpCallFactory(), com.oplus.tblplayer.config.Globals.getOkhttpCacheControl(), this.mMonitor);
        } else {
            factoryBuildHttpDataSourceFactory = com.oplus.tblplayer.managers.TBLSourceManager.buildHttpDataSourceFactory(com.oplus.tblplayer.config.Globals.getUserAgent(), this.mMonitor);
        }
        if (!mediaUrl.isHttpRequestHeadersEmpty()) {
            factoryBuildHttpDataSourceFactory.getDefaultRequestProperties().set(mediaUrl.getHeaders());
        }
        com.google.android.exoplayer2.upstream.DefaultDataSourceFactory defaultDataSourceFactory = new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory(this.mAppContext, factoryBuildHttpDataSourceFactory);
        if (com.oplus.tblplayer.managers.TBLSourceManager.shouldRequirePreCache(mediaUrl) && com.oplus.tblplayer.config.Globals.getPreCacheEnable()) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "getPreCacheDirPath: " + com.oplus.tblplayer.config.Globals.getPreCacheDirPath());
            return com.oplus.tblplayer.managers.TBLSourceManager.buildCacheDataSourceFactory(defaultDataSourceFactory, com.oplus.tblplayer.config.Globals.getGlobalPreCache());
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "buildDataSourceFactory: do not require pre cache.");
        return defaultDataSourceFactory;
    }
}
