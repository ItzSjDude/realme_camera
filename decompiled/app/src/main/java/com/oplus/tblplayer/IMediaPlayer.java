package com.oplus.tblplayer;

import android.annotation.TargetApi;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.SeekParameters;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.misc.TBLTimedText;
import com.oplus.tblplayer.monitor.Report;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

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
        void onBufferingUpdate(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13);
    }

    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    public interface OnErrorListener {
        boolean onError(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2, String str);
    }

    public interface OnInfoListener {
        boolean onInfo(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2);
    }

    public interface OnPlaybackResultListener {
        boolean onPlaybackResult(IMediaPlayer iMediaPlayer, Report report);
    }

    public interface OnPlayerEventListener {
        void onDownstreamSizeChanged(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12);

        void onIsPlayingChanged(IMediaPlayer iMediaPlayer, boolean z);

        void onPlayerStateChanged(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13);
    }

    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer iMediaPlayer);
    }

    public interface OnTimedTextListener {
        void onTimedText(IMediaPlayer iMediaPlayer, TBLTimedText tBLTimedText);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerState {
    }

    void clearVideoSurfaceView(SurfaceView surfaceView);

    void clearVideoTextureView(TextureView textureView);

    void fastSeekTo(long OplusGLSurfaceView_15, boolean z) throws IllegalStateException;

    int getAudioSessionId();

    long getBufferForPlaybackMs();

    long getContentBufferedPosition();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    MediaInfo getMediaInfo();

    @Deprecated
    long getNetSpeed();

    int getPlaybackState();

    float getSpeed();

    @Deprecated
    ITrackInfo[] getTrackInfo();

    int getVideoHeight();

    @Deprecated
    int getVideoSarDen();

    @Deprecated
    int getVideoSarNum();

    int getVideoWidth();

    boolean isLooping();

    boolean isPause();

    @Deprecated
    boolean isPlayable();

    boolean isPlaying();

    boolean isStop();

    void pause() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset();

    void seekTo(long OplusGLSurfaceView_15) throws IllegalStateException;

    @Deprecated
    void setAudioStreamType(int OplusGLSurfaceView_13);

    void setClippingTimeline(long OplusGLSurfaceView_15, long j2) throws IllegalStateException, IllegalArgumentException;

    void setDataSource(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    @TargetApi(14)
    void setDataSource(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    @Deprecated
    void setDataSource(IMediaDataSource iMediaDataSource);

    void setDataSource(MediaUrl mediaUrl) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException;

    void setDisplay(SurfaceHolder surfaceHolder);

    @Deprecated
    void setKeepInBackground(boolean z);

    @Deprecated
    void setLogEnabled(boolean z);

    void setLooping(boolean z);

    void setMediaFormatAttr(HashMap<String, Integer> map);

    void setNetworkType(int OplusGLSurfaceView_13);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPlaybackResultListener(OnPlaybackResultListener onPlaybackResultListener);

    void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnTimedTextListener(OnTimedTextListener onTimedTextListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setPlaybackRate(float COUIBaseListPopupWindow_12);

    @Deprecated
    void setScreenOnWhilePlaying(boolean z);

    void setSeekParameters(SeekParameters seekParameters);

    void setSurface(Surface surface);

    void setVideoScalingMode(int OplusGLSurfaceView_13);

    void setVideoSurfaceView(SurfaceView surfaceView);

    void setVideoTextureView(TextureView textureView);

    void setVolume(float COUIBaseListPopupWindow_12);

    void setVsyncOffsetPercentage(int OplusGLSurfaceView_13);

    @Deprecated
    void setWakeMode(int OplusGLSurfaceView_13);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}
