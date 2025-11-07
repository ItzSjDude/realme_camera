package com.oplus.tblplayer;

import android.content.Context;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Loader;
import com.oplus.tblplayer.TBLExoPlayer;
import com.oplus.tblplayer.ffmpeg.DecoderException;
import com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException;
import com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException;
import com.oplus.tblplayer.render.TBLRenderersFactory;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class TBLRetryPlayer extends TBLExoPlayer {
    private static final int RETRY_WITH_FFMPEG_CDOEC = 1;
    private static final int RETRY_WITH_NONE = 0;
    private static String TAG = "TBLRetryPlayer";
    private boolean maybeRetry;
    private boolean playWhenReady;
    private int repeatMode;
    private int retryCount;
    private Surface surface;
    private float volume;

    static /* synthetic */ int access$308(TBLRetryPlayer tBLRetryPlayer) {
        int OplusGLSurfaceView_13 = tBLRetryPlayer.retryCount;
        tBLRetryPlayer.retryCount = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    public TBLRetryPlayer(Context context) {
        super(context);
        this.retryCount = 0;
    }

    public TBLRetryPlayer(Context context, int OplusGLSurfaceView_13) {
        super(context, OplusGLSurfaceView_13);
        this.retryCount = 0;
    }

    public TBLRetryPlayer(Context context, int OplusGLSurfaceView_13, int i2) {
        super(context, OplusGLSurfaceView_13, i2);
        this.retryCount = 0;
    }

    @Override // com.oplus.tblplayer.TBLExoPlayer
    protected SimpleExoPlayer createInternalPlayer() {
        return super.createInternalPlayer();
    }

    @Override // com.oplus.tblplayer.TBLExoPlayer
    protected void attachAnalyticsListener() {
        this.mInnerListener = new InnerRetryListener();
        this.mInternalPlayer.addAnalyticsListener(this.mInnerListener);
        this.mLoadControl.addEventListener(this.mEventHandler, this.mInnerListener);
    }

    private class InnerRetryListener extends TBLExoPlayer.InnerAnalyticsListener {
        private InnerRetryListener() {
            super();
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
            LogUtil.m25450d(TBLRetryPlayer.TAG, "onRenderedFirstFrame: maybeRetry is " + TBLRetryPlayer.this.maybeRetry + ", preparing is " + TBLRetryPlayer.this.mIsPreparing);
            if (TBLRetryPlayer.this.maybeRetry) {
                return;
            }
            if (TBLRetryPlayer.this.mIsPreparing) {
                TBLRetryPlayer.this.retryCount = 0;
                TBLRetryPlayer.this.maybeRetry = false;
            }
            super.onRenderedFirstFrame(eventTime, surface);
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int OplusGLSurfaceView_13) {
            LogUtil.m25450d(TBLRetryPlayer.TAG, "onPlayerStateChanged: maybeRetry is " + TBLRetryPlayer.this.maybeRetry + ", playWhenReady is " + z + ", playbackState is " + LogUtil.getStateString(OplusGLSurfaceView_13));
            if (TBLRetryPlayer.this.maybeRetry) {
                return;
            }
            super.onPlayerStateChanged(eventTime, z, OplusGLSurfaceView_13);
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int OplusGLSurfaceView_13) {
            LogUtil.m25450d(TBLRetryPlayer.TAG, "onPositionDiscontinuity: maybeRetry is " + TBLRetryPlayer.this.maybeRetry + ", reason is " + LogUtil.getDiscontinuityReasonString(OplusGLSurfaceView_13));
            if (TBLRetryPlayer.this.maybeRetry) {
                return;
            }
            super.onPositionDiscontinuity(eventTime, OplusGLSurfaceView_13);
        }

        @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onLoadError(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            LogUtil.m25450d(TBLRetryPlayer.TAG, "onLoadError: " + iOException);
            if (iOException instanceof ParserException) {
                TBLRetryPlayer.this.maybeRetry = true;
            } else if ((iOException instanceof Loader.UnexpectedLoaderException) && !(iOException.getCause() instanceof OutOfMemoryError)) {
                TBLRetryPlayer.this.maybeRetry = true;
            }
            if (TBLRetryPlayer.this.maybeRetryStartPlayer(1)) {
                TBLRetryPlayer.this.showToast("Load error. will retry!!!");
            } else {
                super.onLoadError(eventTime, loadEventInfo, mediaLoadData, iOException, z);
            }
        }

        @Override // com.oplus.tblplayer.TBLExoPlayer.InnerAnalyticsListener, com.google.android.exoplayer2.analytics.AnalyticsListener
        public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
            LogUtil.m25451d(TBLRetryPlayer.TAG, "onPlayerError: type = " + exoPlaybackException.type, exoPlaybackException);
            Throwable cause = exoPlaybackException.getCause();
            int OplusGLSurfaceView_13 = exoPlaybackException.type;
            if ((cause instanceof DecoderException) || (cause instanceof MediaCodecRenderer.DecoderInitializationException)) {
                TBLRetryPlayer.this.maybeRetry = true;
            } else if (((cause instanceof IllegalStateException) && OplusGLSurfaceView_13 == 1) || (cause instanceof FfmpegAudioDecoderException)) {
                TBLRetryPlayer.this.maybeRetry = true;
            } else if (cause instanceof FfmpegVideoDecoderException) {
                TBLRetryPlayer.this.maybeRetry = true;
                TBLRetryPlayer.access$308(TBLRetryPlayer.this);
            }
            if (TBLRetryPlayer.this.maybeRetryStartPlayer(1)) {
                TBLRetryPlayer.this.showToast("Player error. will retry!!!");
            } else {
                super.onPlayerError(eventTime, exoPlaybackException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        LogUtil.m25456w(TAG, "Should show message is " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRetryStartPlayer(int OplusGLSurfaceView_13) {
        if (!this.maybeRetry || this.retryCount >= 2 || OplusGLSurfaceView_13 <= 0) {
            return false;
        }
        if (OplusGLSurfaceView_13 == 1) {
            this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.TBLRetryPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    TBLRetryPlayer.this.retryPlayerAfterError();
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryPlayerAfterError() {
        if (this.mInternalPlayer == null) {
            LogUtil.m25450d(TAG, "retryPlayer canceled for player is released");
            return;
        }
        LogUtil.m25450d(TAG, "retryPlayerAfterError");
        savePlayerState();
        this.mInternalPlayer.removeAnalyticsListener(this.mInnerListener);
        this.mInternalPlayer.removeAnalyticsListener(this.mMonitor);
        this.mInternalPlayer.stop(true);
        this.maybeRetry = false;
        this.retryCount++;
        this.mRenderersFactory = new TBLRenderersFactory(this.mAppContext, 2);
        this.mInternalPlayer = ExoPlayerFactory.newSimpleInstance(this.mAppContext, this.mRenderersFactory, this.mTrackSelector, this.mLoadControl);
        this.mInternalPlayer.addAnalyticsListener(this.mInnerListener);
        this.mInternalPlayer.addAnalyticsListener(this.mMonitor);
        resumePlayer();
    }

    private void savePlayerState() {
        if (this.mInternalPlayer == null) {
            LogUtil.m25450d(TAG, "savePlayerState failed, player is null !");
            return;
        }
        this.surface = getInternalSurface();
        this.playWhenReady = this.mInternalPlayer.getPlayWhenReady();
        this.repeatMode = this.mInternalPlayer.getRepeatMode();
        this.volume = this.mInternalPlayer.getVolume();
        LogUtil.m25450d(TAG, "retryPlayerAfterError: surface = " + this.surface);
        LogUtil.m25450d(TAG, "retryPlayerAfterError: playWhenReady = " + this.playWhenReady);
        LogUtil.m25450d(TAG, "retryPlayerAfterError: repeatMode = " + this.repeatMode);
    }

    private void resumePlayer() {
        this.mInternalPlayer.setVideoSurface(this.surface);
        this.mInternalPlayer.setPlayWhenReady(this.playWhenReady);
        this.mInternalPlayer.setVolume(this.volume);
        this.mInternalPlayer.setRepeatMode(this.repeatMode);
        this.mInternalPlayer.prepare(this.mediaSource);
    }

    public Surface getInternalSurface() {
        if (this.mInternalPlayer != null && (this.mInternalPlayer instanceof SimpleExoPlayer)) {
            return (Surface) ReflectUtil.getField(this.mInternalPlayer, Surface.class, "surface");
        }
        return null;
    }
}
