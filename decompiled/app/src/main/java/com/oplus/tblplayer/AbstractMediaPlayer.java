package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public abstract class AbstractMediaPlayer implements com.oplus.tblplayer.IMediaPlayer {
    private com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private com.oplus.tblplayer.IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private com.oplus.tblplayer.IMediaPlayer.OnErrorListener mOnErrorListener;
    private com.oplus.tblplayer.IMediaPlayer.OnInfoListener mOnInfoListener;
    private com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener mOnPlaybackResultListener;
    private com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener mOnPlayerEventListener;
    private com.oplus.tblplayer.IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
    private com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void fastSeekTo(long j_renamed, boolean z_renamed) throws java.lang.IllegalStateException {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setMediaFormatAttr(java.util.HashMap<java.lang.String, java.lang.Integer> map) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setPlaybackRate(float f_renamed) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVsyncOffsetPercentage(int i_renamed) {
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPreparedListener(com.oplus.tblplayer.IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnCompletionListener(com.oplus.tblplayer.IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnBufferingUpdateListener(com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnSeekCompleteListener(com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnVideoSizeChangedListener(com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnErrorListener(com.oplus.tblplayer.IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnInfoListener(com.oplus.tblplayer.IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnTimedTextListener(com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        this.mOnTimedTextListener = onTimedTextListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPlaybackResultListener(com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener) {
        this.mOnPlaybackResultListener = onPlaybackResultListener;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setOnPlayerEventListener(com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener onPlayerEventListener) {
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
        com.oplus.tblplayer.IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this);
        }
    }

    protected final void notifyOnCompletion() {
        com.oplus.tblplayer.IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this);
        }
    }

    protected final void notifyOnBufferingUpdate(int i_renamed) {
        com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(this, i_renamed);
        }
    }

    protected final void notifyOnSeekComplete() {
        com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(this);
        }
    }

    protected final void notifyOnVideoSizeChanged(int i_renamed, int i2, int i3, float f_renamed) {
        com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this, i_renamed, i2, i3, f_renamed);
        }
    }

    protected final boolean notifyOnError(int i_renamed, int i2, java.lang.String str) {
        com.oplus.tblplayer.IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        return onErrorListener != null && onErrorListener.onError(this, i_renamed, i2, str);
    }

    protected final boolean notifyOnInfo(int i_renamed, int i2) {
        com.oplus.tblplayer.IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        return onInfoListener != null && onInfoListener.onInfo(this, i_renamed, i2);
    }

    protected final void notifyOnTimedText(com.oplus.tblplayer.misc.TBLTimedText tBLTimedText) {
        com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener onTimedTextListener = this.mOnTimedTextListener;
        if (onTimedTextListener != null) {
            onTimedTextListener.onTimedText(this, tBLTimedText);
        }
    }

    protected final void notifyOnPlaybackResult(com.oplus.tblplayer.monitor.Report report) {
        com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener = this.mOnPlaybackResultListener;
        if (onPlaybackResultListener != null) {
            onPlaybackResultListener.onPlaybackResult(this, report);
        }
    }

    protected final void notifyOnPlayerStateChanged(int i_renamed) {
        com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onPlayerStateChanged(this, i_renamed);
        }
    }

    protected final void notifyOnIsPlayingChanged(boolean z_renamed) {
        com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onIsPlayingChanged(this, z_renamed);
        }
    }

    protected final void notifyOnDownstreamSizeChanged(int i_renamed, int i2, int i3, float f_renamed) {
        com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onDownstreamSizeChanged(this, i_renamed, i2, i3, f_renamed);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(com.oplus.tblplayer.misc.IMediaDataSource iMediaDataSource) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoScalingMode(int i_renamed) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setClippingTimeline(long j_renamed, long j2) {
        throw new java.lang.UnsupportedOperationException();
    }
}
