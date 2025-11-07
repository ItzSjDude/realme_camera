package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public interface IMediaPlayer {
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_AUDIO_SEEK_RENDERING_START = 10009;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
    public static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
    public static final int MEDIA_INFO_LOOPING_TRANSITION = 5;
    public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_OPEN_INPUT = 10005;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
    public static final int MEDIA_INFO_VIDEO_HDR_INFO = 4;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_SEEK_RENDERING_START = 10008;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed);
    }

    public interface OnCompletionListener {
        void onCompletion(com.oplus.tblplayer.IMediaPlayer iMediaPlayer);
    }

    public interface OnErrorListener {
        boolean onError(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2, java.lang.String str);
    }

    public interface OnInfoListener {
        boolean onInfo(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2);
    }

    public interface OnPlaybackResultListener {
        boolean onPlaybackResult(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, com.oplus.tblplayer.monitor.Report report);
    }

    public interface OnPlayerEventListener {
        void onDownstreamSizeChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2, int i3, float f_renamed);

        void onIsPlayingChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, boolean z_renamed);

        void onPlayerStateChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed);
    }

    public interface OnPreparedListener {
        void onPrepared(com.oplus.tblplayer.IMediaPlayer iMediaPlayer);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(com.oplus.tblplayer.IMediaPlayer iMediaPlayer);
    }

    public interface OnTimedTextListener {
        void onTimedText(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, com.oplus.tblplayer.misc.TBLTimedText tBLTimedText);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2, int i3, float f_renamed);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlayerState {
    }

    void clearVideoSurfaceView(android.view.SurfaceView surfaceView);

    void clearVideoTextureView(android.view.TextureView textureView);

    void fastSeekTo(long j_renamed, boolean z_renamed) throws java.lang.IllegalStateException;

    int getAudioSessionId();

    long getBufferForPlaybackMs();

    long getContentBufferedPosition();

    long getCurrentPosition();

    java.lang.String getDataSource();

    long getDuration();

    com.oplus.tblplayer.misc.MediaInfo getMediaInfo();

    @java.lang.Deprecated
    long getNetSpeed();

    int getPlaybackState();

    float getSpeed();

    @java.lang.Deprecated
    com.oplus.tblplayer.misc.ITrackInfo[] getTrackInfo();

    int getVideoHeight();

    @java.lang.Deprecated
    int getVideoSarDen();

    @java.lang.Deprecated
    int getVideoSarNum();

    int getVideoWidth();

    boolean isLooping();

    boolean isPause();

    @java.lang.Deprecated
    boolean isPlayable();

    boolean isPlaying();

    boolean isStop();

    void pause() throws java.lang.IllegalStateException;

    void prepareAsync() throws java.lang.IllegalStateException;

    void release();

    void reset();

    void seekTo(long j_renamed) throws java.lang.IllegalStateException;

    @java.lang.Deprecated
    void setAudioStreamType(int i_renamed);

    void setClippingTimeline(long j_renamed, long j2) throws java.lang.IllegalStateException, java.lang.IllegalArgumentException;

    void setDataSource(android.net.Uri uri) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    @android.annotation.TargetApi(14)
    void setDataSource(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    @java.lang.Deprecated
    void setDataSource(com.oplus.tblplayer.misc.IMediaDataSource iMediaDataSource);

    void setDataSource(com.oplus.tblplayer.misc.MediaUrl mediaUrl) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException;

    void setDataSource(java.lang.String str) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    void setDisplay(android.view.SurfaceHolder surfaceHolder);

    @java.lang.Deprecated
    void setKeepInBackground(boolean z_renamed);

    @java.lang.Deprecated
    void setLogEnabled(boolean z_renamed);

    void setLooping(boolean z_renamed);

    void setMediaFormatAttr(java.util.HashMap<java.lang.String, java.lang.Integer> map);

    void setNetworkType(int i_renamed);

    void setOnBufferingUpdateListener(com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(com.oplus.tblplayer.IMediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(com.oplus.tblplayer.IMediaPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(com.oplus.tblplayer.IMediaPlayer.OnInfoListener onInfoListener);

    void setOnPlaybackResultListener(com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener);

    void setOnPlayerEventListener(com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener onPlayerEventListener);

    void setOnPreparedListener(com.oplus.tblplayer.IMediaPlayer.OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void setOnTimedTextListener(com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener onTimedTextListener);

    void setOnVideoSizeChangedListener(com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setPlaybackRate(float f_renamed);

    @java.lang.Deprecated
    void setScreenOnWhilePlaying(boolean z_renamed);

    void setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters);

    void setSurface(android.view.Surface surface);

    void setVideoScalingMode(int i_renamed);

    void setVideoSurfaceView(android.view.SurfaceView surfaceView);

    void setVideoTextureView(android.view.TextureView textureView);

    void setVolume(float f_renamed);

    void setVsyncOffsetPercentage(int i_renamed);

    @java.lang.Deprecated
    void setWakeMode(int i_renamed);

    void start() throws java.lang.IllegalStateException;

    void stop() throws java.lang.IllegalStateException;
}
