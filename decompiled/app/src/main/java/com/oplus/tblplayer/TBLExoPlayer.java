package com.oplus.tblplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.tblplayer.TBLLoadControl;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.managers.SlowMotionManager;
import com.oplus.tblplayer.managers.TBLSourceManager;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.monitor.AnalyticsMonitor;
import com.oplus.tblplayer.monitor.ErrorCodeProvider;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.render.FallbackRenderer;
import com.oplus.tblplayer.render.RollupRenderer;
import com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer;
import com.oplus.tblplayer.render.TBLRenderersFactory;
import com.oplus.tblplayer.utils.AssertUtil;
import com.oplus.tblplayer.utils.CommonUtil;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class TBLExoPlayer extends AbstractMediaPlayer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String TAG = "TBLExoPlayer";
    protected int extractorType;
    private List<FallbackRenderer> fallbackRenderers;
    protected boolean hasComplete;
    protected boolean hasRelease;
    protected Context mAppContext;
    protected Handler mEventHandler;
    protected InnerAnalyticsListener mInnerListener;
    protected SimpleExoPlayer mInternalPlayer;
    protected boolean mIsBuffering;
    protected boolean mIsPreparing;
    protected TBLLoadControl mLoadControl;
    protected MediaUrl mMediaUrl;
    protected AnalyticsMonitor mMonitor;
    protected boolean mOldIsPlaying;
    protected DefaultRenderersFactory mRenderersFactory;
    protected SlowMotionManager mSlowMotion;
    protected DefaultTrackSelector mTrackSelector;
    protected int mVideoHeight;
    protected int mVideoWidth;
    protected MediaSource mediaSource;
    protected int rendererType;
    private List<RollupRenderer> rollupRenderers;

    @Override // com.oplus.tblplayer.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
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
    public void setAudioStreamType(int OplusGLSurfaceView_13) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setWakeMode(int OplusGLSurfaceView_13) {
    }

    public TBLExoPlayer(Context context) {
        this(context, 0);
    }

    public TBLExoPlayer(Context context, int OplusGLSurfaceView_13) {
        this(context, OplusGLSurfaceView_13, 0);
    }

    public TBLExoPlayer(Context context, int OplusGLSurfaceView_13, int i2) {
        this.mMediaUrl = null;
        this.mediaSource = null;
        this.mIsPreparing = false;
        this.mIsBuffering = false;
        this.hasComplete = false;
        this.hasRelease = false;
        this.mOldIsPlaying = false;
        this.mSlowMotion = null;
        LogUtil.m25450d(TAG, "TBLExoPlayer: create");
        this.mAppContext = context.getApplicationContext();
        this.mEventHandler = new Handler(getLooper());
        this.rendererType = OplusGLSurfaceView_13;
        this.extractorType = i2;
        TraceUtil.beginSection("TBLExoPlayer.createPlayer");
        this.mInternalPlayer = createInternalPlayer();
        TraceUtil.endSection();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Create internal player success: ");
        sb.append(this.mInternalPlayer != null);
        LogUtil.m25450d(str, sb.toString());
        attachAnalyticsListener();
        this.mMonitor = new AnalyticsMonitor(this.mInternalPlayer, this.mTrackSelector);
        this.mInternalPlayer.addAnalyticsListener(this.mMonitor);
        this.fallbackRenderers = new ArrayList(2);
        this.rollupRenderers = new ArrayList(2);
    }

    protected Looper getLooper() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    protected SimpleExoPlayer createInternalPlayer() {
        if (this.mTrackSelector == null) {
            this.mTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory());
        }
        if (this.mRenderersFactory == null) {
            this.mRenderersFactory = new TBLRenderersFactory(this.mAppContext, this.rendererType);
        }
        if (this.mLoadControl == null) {
            this.mLoadControl = new TBLLoadControl();
        }
        return ExoPlayerFactory.newSimpleInstance(this.mAppContext, this.mRenderersFactory, this.mTrackSelector, this.mLoadControl);
    }

    protected void attachAnalyticsListener() {
        this.mInnerListener = new InnerAnalyticsListener();
        this.mInternalPlayer.addAnalyticsListener(this.mInnerListener);
        this.mLoadControl.addEventListener(this.mEventHandler, this.mInnerListener);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setNetworkType(int OplusGLSurfaceView_13) {
        LogUtil.m25450d(TAG, "setNetworkType: networkType is " + OplusGLSurfaceView_13);
        updateNetworkType(OplusGLSurfaceView_13);
    }

    public void updateNetworkType(int OplusGLSurfaceView_13) {
        TBLLoadControl tBLLoadControl;
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null || (tBLLoadControl = this.mLoadControl) == null) {
            return;
        }
        simpleExoPlayer.createMessage(tBLLoadControl).setType(1).setPayload(Integer.valueOf(OplusGLSurfaceView_13)).send();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVsyncOffsetPercentage(int OplusGLSurfaceView_13) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVsyncOffsetPercentage(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setMediaFormatAttr(HashMap<String, Integer> map) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setMediaFormatAttr(map);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getBufferForPlaybackMs() {
        TBLLoadControl tBLLoadControl;
        LogUtil.m25450d(TAG, "getBufferForPlaybackMs");
        if (this.mInternalPlayer == null || (tBLLoadControl = this.mLoadControl) == null) {
            return 0L;
        }
        return C1547C.usToMs(tBLLoadControl.getLoadPolicy().bufferForPlaybackUs);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        LogUtil.m25450d(TAG, "setDisplay");
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        LogUtil.m25450d(TAG, "setVideoSurfaceView");
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        LogUtil.m25450d(TAG, "clearVideoSurfaceView");
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.clearVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoTextureView(TextureView textureView) {
        LogUtil.m25450d(TAG, "setVideoTextureView");
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoTextureView(TextureView textureView) {
        LogUtil.m25450d(TAG, "clearVideoTextureView");
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.clearVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSurface(Surface surface) {
        LogUtil.m25450d(TAG, "setSurface: surface is " + surface);
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurface(surface);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setVideoScalingMode(int OplusGLSurfaceView_13) {
        LogUtil.m25450d(TAG, "setVideoScalingMode: mode is " + OplusGLSurfaceView_13);
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoScalingMode(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(MediaUrl mediaUrl) {
        setMediaUrlInternal((MediaUrl) AssertUtil.checkNotNull(mediaUrl));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(String str) {
        setDataSource(Uri.parse(str));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        throw new UnsupportedOperationException("no support");
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri) {
        setMediaUrlInternal(new MediaUrl.Builder(uri).build());
    }

    protected synchronized void setMediaUrlInternal(MediaUrl mediaUrl) {
        LogUtil.m25450d(TAG, "setDataSource: uri is " + mediaUrl);
        boolean z = true;
        if (this.mInternalPlayer == null || this.mInternalPlayer.getPlaybackState() != 1) {
            z = false;
        }
        AssertUtil.checkState(z);
        this.mMediaUrl = (MediaUrl) AssertUtil.checkNotNull(mediaUrl);
        this.mediaSource = TBLSourceManager.buildMediaSource(buildDataSourceFactory(this.mMediaUrl), this.mMediaUrl, this.extractorType);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri, Map<String, String> map) {
        setMediaUrlInternal(new MediaUrl.Builder(uri).setHeaders(map).build());
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public String getDataSource() {
        if (this.mInternalPlayer == null) {
            throw new IllegalStateException("Internal player is null.");
        }
        MediaUrl mediaUrl = this.mMediaUrl;
        if (mediaUrl == null || mediaUrl.getUri() == null) {
            return null;
        }
        return this.mMediaUrl.getUri().toString();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setClippingTimeline(long OplusGLSurfaceView_15, long j2) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null || this.mediaSource == null) {
            throw new IllegalStateException("Not set data source.");
        }
        if (simpleExoPlayer.getPlaybackState() != 1) {
            throw new IllegalStateException("Player is not idle state.");
        }
        if (!(this.mediaSource instanceof ExtractorMediaSource)) {
            throw new IllegalArgumentException("Not PlatformImplementations.kt_3 single-period source.");
        }
        LogUtil.m25450d(TAG, "setClippingTimeline: startUs is " + OplusGLSurfaceView_15 + ", endUs is " + j2);
        this.mediaSource = new ClippingMediaSource(this.mediaSource, OplusGLSurfaceView_15, j2);
    }

    private void setTrackRendererDisable(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.mInternalPlayer.getRendererCount(); i2++) {
            if (this.mInternalPlayer.getRendererType(i2) == OplusGLSurfaceView_13) {
                DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
                defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setRendererDisabled(i2, true).build());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        if (this.mInternalPlayer.getPlaybackState() >= 3) {
            LogUtil.m25456w(TAG, "prepareAsync: it is preload player, had prepared!");
            notifyOnInfo(702, this.mInternalPlayer.getBufferedPercentage());
            notifyOnPrepared();
            this.mIsPreparing = false;
            return;
        }
        LogUtil.m25450d(TAG, "prepareAsync: do  prepare");
        this.mIsPreparing = true;
        this.mOldIsPlaying = false;
        this.mMonitor.startSession(this.mMediaUrl);
        maybeResetFallbackRollupRenderers();
        this.mInternalPlayer.setPlayWhenReady(false);
        TraceUtil.beginSection("TBLExoPlayer.prepareAsync");
        this.mInternalPlayer.prepare(this.mediaSource);
        TraceUtil.endSection();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void start() throws IllegalStateException {
        LogUtil.m25450d(TAG, TtmlNode.START);
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        TraceUtil.beginSection("TBLExoPlayer.start");
        this.mInternalPlayer.setPlayWhenReady(true);
        TraceUtil.endSection();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void stop() throws IllegalStateException {
        LogUtil.m25450d(TAG, "stop");
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        this.mInternalPlayer.stop();
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            slowMotionManager.stop();
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void pause() throws IllegalStateException {
        LogUtil.m25450d(TAG, VideoRecordMsgData.EVENT_PAUSE);
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        this.mInternalPlayer.setPlayWhenReady(false);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void reset() {
        LogUtil.m25450d(TAG, "reset");
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop(true);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void release() {
        LogUtil.m25450d(TAG, "release");
        maybeNotifyPlaybackReport();
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
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
            List<FallbackRenderer> list = this.fallbackRenderers;
            if (list != null) {
                list.clear();
                this.fallbackRenderers = null;
            }
            List<RollupRenderer> list2 = this.rollupRenderers;
            if (list2 != null) {
                list2.clear();
                this.rollupRenderers = null;
            }
            SlowMotionManager slowMotionManager = this.mSlowMotion;
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
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        return simpleExoPlayer != null && simpleExoPlayer.getPlaybackState() == 3 && this.mInternalPlayer.getPlayWhenReady();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPause() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
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
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        return simpleExoPlayer == null || simpleExoPlayer.getPlaybackState() == 1;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaybackState() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 1;
        }
        return simpleExoPlayer.getPlaybackState();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        LogUtil.m25450d(TAG, "setSeekParameters: " + seekParameters);
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setSeekParameters(seekParameters);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void seekTo(long OplusGLSurfaceView_15) throws IllegalStateException {
        LogUtil.m25450d(TAG, "seekTo: msec is " + OplusGLSurfaceView_15);
        if (this.mInternalPlayer == null) {
            return;
        }
        this.mOldIsPlaying = isPlaying();
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            OplusGLSurfaceView_15 = slowMotionManager.adaptPosition(OplusGLSurfaceView_15, true);
        }
        simpleExoPlayer.seekTo(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void fastSeekTo(long OplusGLSurfaceView_15, boolean z) throws IllegalStateException {
        LogUtil.m25450d(TAG, "fastSeekTo: msec is " + OplusGLSurfaceView_15);
        if (this.mInternalPlayer == null) {
            return;
        }
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        if (slowMotionManager != null) {
            OplusGLSurfaceView_15 = slowMotionManager.adaptPosition(OplusGLSurfaceView_15, true);
        }
        this.mInternalPlayer.fastSeekTo(OplusGLSurfaceView_15, z);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setPlaybackRate(float COUIBaseListPopupWindow_12) {
        PlaybackParameters playbackParameters = new PlaybackParameters(COUIBaseListPopupWindow_12);
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlaybackParameters(playbackParameters);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getCurrentPosition() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long currentPosition = simpleExoPlayer.getCurrentPosition();
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(currentPosition, false) : currentPosition;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getDuration() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long duration = simpleExoPlayer.getDuration();
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(duration, false) : duration;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getSpeed() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0.0f;
        }
        return simpleExoPlayer.getPlaybackParameters().speed;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVolume(float COUIBaseListPopupWindow_12) {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setVolume(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLooping(boolean z) {
        LogUtil.m25450d(TAG, "setLooping: looping is " + z);
        if (z) {
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
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0;
        }
        return simpleExoPlayer.getAudioSessionId();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public MediaInfo getMediaInfo() {
        AnalyticsMonitor analyticsMonitor = this.mMonitor;
        if (analyticsMonitor == null || !analyticsMonitor.checkState()) {
            return null;
        }
        return this.mMonitor.getMediaInfo();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getNetSpeed() {
        AnalyticsMonitor analyticsMonitor;
        if (this.mInternalPlayer == null || (analyticsMonitor = this.mMonitor) == null) {
            return 0L;
        }
        return analyticsMonitor.getNetSpeed(this.mAppContext.getApplicationInfo().uid);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getContentBufferedPosition() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long contentBufferedPosition = simpleExoPlayer.getContentBufferedPosition();
        SlowMotionManager slowMotionManager = this.mSlowMotion;
        return slowMotionManager != null ? slowMotionManager.adaptPosition(contentBufferedPosition, false) : contentBufferedPosition;
    }

    public int getBufferedPercentage() {
        SimpleExoPlayer simpleExoPlayer = this.mInternalPlayer;
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
            return Util.constrainValue((int) ((contentBufferedPosition * 100) / duration), 0, 100);
        }
        return simpleExoPlayer.getBufferedPercentage();
    }

    protected class InnerAnalyticsListener implements AnalyticsListener, TBLLoadControl.EventListener {
        protected InnerAnalyticsListener() {
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13, Format format) {
            TBLExoPlayer.this.maybeNotifyHdrInfo(OplusGLSurfaceView_13, format);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
            if (mediaLoadData.trackType == 2) {
                TBLExoPlayer.this.mVideoHeight = mediaLoadData.trackFormat.height;
                TBLExoPlayer.this.mVideoWidth = mediaLoadData.trackFormat.width;
                int OplusGLSurfaceView_13 = mediaLoadData.trackFormat.rotationDegrees;
                float COUIBaseListPopupWindow_12 = mediaLoadData.trackFormat.pixelWidthHeightRatio;
                LogUtil.dfmt(TBLExoPlayer.TAG, "notifyOnDownstreamSizeChanged: [%IntrinsicsJvm.kt_5, %IntrinsicsJvm.kt_5, %IntrinsicsJvm.kt_5, %COUIBaseListPopupWindow_12]", Integer.valueOf(TBLExoPlayer.this.mVideoWidth), Integer.valueOf(TBLExoPlayer.this.mVideoHeight), Integer.valueOf(OplusGLSurfaceView_13), Float.valueOf(COUIBaseListPopupWindow_12));
                TBLExoPlayer tBLExoPlayer = TBLExoPlayer.this;
                tBLExoPlayer.notifyOnDownstreamSizeChanged(tBLExoPlayer.mVideoWidth, TBLExoPlayer.this.mVideoHeight, OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
            TBLExoPlayer tBLExoPlayer = TBLExoPlayer.this;
            tBLExoPlayer.mVideoWidth = OplusGLSurfaceView_13;
            tBLExoPlayer.mVideoHeight = i2;
            LogUtil.dfmt(TBLExoPlayer.TAG, "onVideoSizeChanged: [%IntrinsicsJvm.kt_5, %IntrinsicsJvm.kt_5, %IntrinsicsJvm.kt_5, %COUIBaseListPopupWindow_12]", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(COUIBaseListPopupWindow_12));
            TBLExoPlayer.this.notifyOnVideoSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
            if (i3 > 0) {
                TBLExoPlayer.this.notifyOnInfo(10001, i3);
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
            if (TBLExoPlayer.this.mIsPreparing) {
                LogUtil.m25450d(TBLExoPlayer.TAG, "onRenderedFirstFrame: will notifyOnPrepared");
                TBLExoPlayer.this.maybeInitializeSlowMotion();
                TBLExoPlayer.this.notifyOnPrepared();
                TBLExoPlayer.this.mIsPreparing = false;
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int OplusGLSurfaceView_13) {
            LogUtil.m25450d(TBLExoPlayer.TAG, "onPlayerStateChanged: playWhenReady is " + z + ", " + LogUtil.getStateString(OplusGLSurfaceView_13));
            TBLExoPlayer.this.notifyOnPlayerStateChanged(OplusGLSurfaceView_13);
            TBLExoPlayer.this.maybeNotifyBuffingInfo(z, OplusGLSurfaceView_13);
            TBLExoPlayer.this.maybeNotifyPlayingChanged(z, OplusGLSurfaceView_13);
            TBLExoPlayer.this.maybeNotifyPlaybackCompletion(z, OplusGLSurfaceView_13);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
            if (TBLExoPlayer.this.maybeRetryWithBackupSource()) {
                return;
            }
            if (TBLExoPlayer.this.maybeRetryWithFallbackRollupRenderer(exoPlaybackException)) {
                LogUtil.m25450d(TBLExoPlayer.TAG, "onPlayerError: will retry player with disable error renderer.");
            } else {
                TBLExoPlayer.this.notifyOnError(exoPlaybackException.type, ErrorCodeProvider.parseException(TBLExoPlayer.this.mInternalPlayer, exoPlaybackException), exoPlaybackException.getMessage());
            }
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13) {
            LogUtil.m25450d(TBLExoPlayer.TAG, "onPositionDiscontinuity: " + LogUtil.getDiscontinuityReasonString(OplusGLSurfaceView_13));
            if (TBLExoPlayer.this.isLooping() && OplusGLSurfaceView_13 == 0) {
                TBLExoPlayer.this.notifyOnInfo(5, 0);
            }
        }

        @Override // com.oplus.tblplayer.TBLLoadControl.EventListener
        public void onBufferPercentChanged(int OplusGLSurfaceView_13) {
            LogUtil.m25450d(TBLExoPlayer.TAG, "onBufferPercentChanged: percent is " + OplusGLSurfaceView_13);
            TBLExoPlayer.this.notifyOnBufferingUpdate(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.tblplayer.TBLLoadControl.EventListener
        public void onLoadControlStateChanged(int OplusGLSurfaceView_13) {
            LogUtil.m25450d(TBLExoPlayer.TAG, "onLoadControlStateChanged: state is " + OplusGLSurfaceView_13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRetryWithBackupSource() {
        MediaUrl mediaUrl;
        if (this.hasRelease || (mediaUrl = this.mMediaUrl) == null || !mediaUrl.hasNextBackupSource()) {
            return false;
        }
        MediaUrl mediaUrlNextBackupSource = this.mMediaUrl.nextBackupSource();
        this.mInternalPlayer.prepare(TBLSourceManager.buildMediaSource(buildDataSourceFactory(mediaUrlNextBackupSource), mediaUrlNextBackupSource, this.extractorType), false, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeInitializeSlowMotion() {
        if (CommonUtil.isSlowMotionHsr(this.mMediaUrl.getOverrideExtension())) {
            this.mSlowMotion = SlowMotionManager.create(this.mAppContext, this, this.mMediaUrl.getOverrideExtension(), this.mInternalPlayer.getVideoFormat().frameRate, 30, this.mInternalPlayer.getDuration());
            if (this.mSlowMotion != null) {
                setTrackRendererDisable(1);
                this.mSlowMotion.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRetryWithFallbackRollupRenderer(ExoPlaybackException exoPlaybackException) {
        Renderer[] rendererArr;
        Renderer[] rendererArr2;
        Throwable cause = exoPlaybackException.getCause();
        int OplusGLSurfaceView_13 = exoPlaybackException.rendererIndex;
        if (this.hasRelease || this.fallbackRenderers == null || this.rollupRenderers == null || this.rendererType != 0 || (exoPlaybackException.getCause() instanceof TBLMediaCodecVideoRenderer.VideoOverSpecificationException)) {
            return false;
        }
        if (exoPlaybackException.type == 1 && (rendererArr2 = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers")) != null && OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < rendererArr2.length) {
            Renderer renderer = rendererArr2[OplusGLSurfaceView_13];
            if (renderer instanceof FallbackRenderer) {
                if ((renderer instanceof RollupRenderer) && ((RollupRenderer) renderer).isRollup()) {
                    LogUtil.m25456w(TAG, "maybeRetryWithFallbackRollupRenderer: already tried ffmpeg audio decoder,exit");
                    return false;
                }
                LogUtil.m25457w(TAG, "maybeRetryWithFallbackRollupRenderer: will fallback renderer: " + renderer.getClass().getSimpleName(), cause);
                FallbackRenderer fallbackRenderer = (FallbackRenderer) renderer;
                fallbackRenderer.setFallbackRenderer(true);
                this.fallbackRenderers.add(fallbackRenderer);
                this.mInternalPlayer.retry();
                return true;
            }
        }
        if (exoPlaybackException.type == 1 && exoPlaybackException.toString().contains("FfmpegAudioDecoderException") && (rendererArr = (Renderer[]) ReflectUtil.getField(this.mInternalPlayer, Renderer[].class, "renderers")) != null) {
            for (Renderer renderer2 : rendererArr) {
                if (renderer2 instanceof RollupRenderer) {
                    LogUtil.m25456w(TAG, "maybeRetryWithFallbackRollupRenderer: will rollup renderer: " + renderer2.getClass().getSimpleName());
                    RollupRenderer rollupRenderer = (RollupRenderer) renderer2;
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
            Iterator<FallbackRenderer> it = this.fallbackRenderers.iterator();
            while (it.hasNext()) {
                it.next().setFallbackRenderer(false);
            }
            this.fallbackRenderers.clear();
        }
        if (this.rollupRenderers != null && !this.rollupRenderers.isEmpty()) {
            Iterator<RollupRenderer> it2 = this.rollupRenderers.iterator();
            while (it2.hasNext()) {
                it2.next().setRollupRenderer(false);
            }
            this.rollupRenderers.clear();
        }
    }

    private void maybeNotifyPlaybackReport() {
        AnalyticsMonitor analyticsMonitor = this.mMonitor;
        if (analyticsMonitor == null || !analyticsMonitor.checkState()) {
            return;
        }
        Report reportEndSession = this.mMonitor.endSession();
        LogUtil.m25450d(TAG, "notifyPlaybackReport: " + reportEndSession);
        if (reportEndSession != null) {
            notifyOnPlaybackResult(reportEndSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyBuffingInfo(boolean z, int OplusGLSurfaceView_13) {
        if (!this.mIsBuffering) {
            if (OplusGLSurfaceView_13 == 2) {
                notifyOnInfo(701, this.mInternalPlayer.getBufferedPercentage());
                this.mIsBuffering = true;
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
            notifyOnInfo(702, this.mInternalPlayer.getBufferedPercentage());
            this.mIsBuffering = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyPlayingChanged(boolean z, int OplusGLSurfaceView_13) {
        boolean zIsPlaying = isPlaying();
        if (this.mOldIsPlaying != zIsPlaying) {
            LogUtil.m25450d(TAG, "notifyOnIsPlayingChanged: isPlaying is " + zIsPlaying);
            notifyOnIsPlayingChanged(zIsPlaying);
            this.mOldIsPlaying = zIsPlaying;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyHdrInfo(int OplusGLSurfaceView_13, Format format) {
        if (OplusGLSurfaceView_13 != 2 || !this.mIsPreparing || format == null || format.colorInfo == null) {
            return;
        }
        if (format.colorInfo.colorTransfer == 6 || format.colorInfo.colorTransfer == 7) {
            LogUtil.m25450d(TAG, "maybeNotifyHdrInfo: " + format.colorInfo);
            notifyOnInfo(4, format.colorInfo.colorTransfer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyPlaybackCompletion(boolean z, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 2 && OplusGLSurfaceView_13 != 3) {
            if (OplusGLSurfaceView_13 == 4 && !this.hasComplete) {
                if (z) {
                    this.mInternalPlayer.setPlayWhenReady(false);
                }
                LogUtil.m25450d(TAG, "STATE_ENDED will callback completion.");
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

    public DataSource.Factory buildDataSourceFactory(MediaUrl mediaUrl) {
        HttpDataSource.Factory factoryBuildHttpDataSourceFactory;
        if (Globals.getOkhttpEnable()) {
            factoryBuildHttpDataSourceFactory = TBLSourceManager.buildOkHttpDataSourceFactory(Globals.getUserAgent(), Globals.getOkhttpCallFactory(), Globals.getOkhttpCacheControl(), this.mMonitor);
        } else {
            factoryBuildHttpDataSourceFactory = TBLSourceManager.buildHttpDataSourceFactory(Globals.getUserAgent(), this.mMonitor);
        }
        if (!mediaUrl.isHttpRequestHeadersEmpty()) {
            factoryBuildHttpDataSourceFactory.getDefaultRequestProperties().set(mediaUrl.getHeaders());
        }
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(this.mAppContext, factoryBuildHttpDataSourceFactory);
        if (TBLSourceManager.shouldRequirePreCache(mediaUrl) && Globals.getPreCacheEnable()) {
            LogUtil.m25450d(TAG, "getPreCacheDirPath: " + Globals.getPreCacheDirPath());
            return TBLSourceManager.buildCacheDataSourceFactory(defaultDataSourceFactory, Globals.getGlobalPreCache());
        }
        LogUtil.m25450d(TAG, "buildDataSourceFactory: do not require pre cache.");
        return defaultDataSourceFactory;
    }
}
