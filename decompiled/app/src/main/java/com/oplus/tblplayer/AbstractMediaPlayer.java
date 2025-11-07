package com.oplus.tblplayer;

import com.google.android.exoplayer2.SeekParameters;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.misc.TBLTimedText;
import com.oplus.tblplayer.monitor.Report;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class AbstractMediaPlayer implements IMediaPlayer {
    private IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private IMediaPlayer.OnErrorListener mOnErrorListener;
    private IMediaPlayer.OnInfoListener mOnInfoListener;
    private IMediaPlayer.OnPlaybackResultListener mOnPlaybackResultListener;
    private IMediaPlayer.OnPlayerEventListener mOnPlayerEventListener;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
    private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void fastSeekTo(long OplusGLSurfaceView_15, boolean z) throws IllegalStateException {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(MediaUrl mediaUrl) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setMediaFormatAttr(HashMap<String, Integer> map) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setPlaybackRate(float COUIBaseListPopupWindow_12) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVsyncOffsetPercentage(int OplusGLSurfaceView_13) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        this.mOnTimedTextListener = onTimedTextListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPlaybackResultListener(IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener) {
        this.mOnPlaybackResultListener = onPlaybackResultListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPlayerEventListener(IMediaPlayer.OnPlayerEventListener onPlayerEventListener) {
        this.mOnPlayerEventListener = onPlayerEventListener;
    }

    public void resetListeners() {
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnTimedTextListener = null;
        this.mOnPlaybackResultListener = null;
        this.mOnPlayerEventListener = null;
    }

    protected final void notifyOnPrepared() {
        IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this);
        }
    }

    protected final void notifyOnCompletion() {
        IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this);
        }
    }

    protected final void notifyOnBufferingUpdate(int OplusGLSurfaceView_13) {
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(this, OplusGLSurfaceView_13);
        }
    }

    protected final void notifyOnSeekComplete() {
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(this);
        }
    }

    protected final void notifyOnVideoSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this, OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
        }
    }

    protected final boolean notifyOnError(int OplusGLSurfaceView_13, int i2, String str) {
        IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        return onErrorListener != null && onErrorListener.onError(this, OplusGLSurfaceView_13, i2, str);
    }

    protected final boolean notifyOnInfo(int OplusGLSurfaceView_13, int i2) {
        IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        return onInfoListener != null && onInfoListener.onInfo(this, OplusGLSurfaceView_13, i2);
    }

    protected final void notifyOnTimedText(TBLTimedText tBLTimedText) {
        IMediaPlayer.OnTimedTextListener onTimedTextListener = this.mOnTimedTextListener;
        if (onTimedTextListener != null) {
            onTimedTextListener.onTimedText(this, tBLTimedText);
        }
    }

    protected final void notifyOnPlaybackResult(Report report) {
        IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener = this.mOnPlaybackResultListener;
        if (onPlaybackResultListener != null) {
            onPlaybackResultListener.onPlaybackResult(this, report);
        }
    }

    protected final void notifyOnPlayerStateChanged(int OplusGLSurfaceView_13) {
        IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onPlayerStateChanged(this, OplusGLSurfaceView_13);
        }
    }

    protected final void notifyOnIsPlayingChanged(boolean z) {
        IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onIsPlayingChanged(this, z);
        }
    }

    protected final void notifyOnDownstreamSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
        IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onDownstreamSizeChanged(this, OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoScalingMode(int OplusGLSurfaceView_13) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setClippingTimeline(long OplusGLSurfaceView_15, long j2) {
        throw new UnsupportedOperationException();
    }
}
