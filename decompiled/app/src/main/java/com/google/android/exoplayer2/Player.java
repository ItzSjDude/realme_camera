package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public interface Player {
    public static final int DISCONTINUITY_REASON_AD_INSERTION = 3;
    public static final int DISCONTINUITY_REASON_INTERNAL = 4;
    public static final int DISCONTINUITY_REASON_PERIOD_TRANSITION = 0;
    public static final int DISCONTINUITY_REASON_SEEK = 1;
    public static final int DISCONTINUITY_REASON_SEEK_ADJUSTMENT = 2;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;
    public static final int TIMELINE_CHANGE_REASON_DYNAMIC = 2;
    public static final int TIMELINE_CHANGE_REASON_PREPARED = 0;
    public static final int TIMELINE_CHANGE_REASON_RESET = 1;

    public interface AudioComponent {
        void addAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener);

        void clearAuxEffectInfo();

        com.google.android.exoplayer2.audio.AudioAttributes getAudioAttributes();

        int getAudioSessionId();

        float getVolume();

        void removeAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener);

        @java.lang.Deprecated
        void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes);

        void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, boolean z_renamed);

        void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo);

        void setVolume(float f_renamed);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    public interface EventListener {
        default void onLoadingChanged(boolean z_renamed) {
        }

        default void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        }

        default void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        }

        default void onPlayerStateChanged(boolean z_renamed, int i_renamed) {
        }

        default void onPositionDiscontinuity(int i_renamed) {
        }

        default void onPrepared() {
        }

        default void onRepeatModeChanged(int i_renamed) {
        }

        default void onSeekCompleted(int i_renamed, int i2) {
        }

        default void onSeekProcessed() {
        }

        default void onShuffleModeEnabledChanged(boolean z_renamed) {
        }

        default void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i_renamed) {
        }

        default void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        }
    }

    public interface MetadataComponent {
        void addMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput);

        void removeMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public interface TextComponent {
        void addTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput);

        void removeTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    public interface VideoComponent {
        void addVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener);

        void clearCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener);

        void clearVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener);

        void clearVideoSurface();

        void clearVideoSurface(android.view.Surface surface);

        void clearVideoSurfaceHolder(android.view.SurfaceHolder surfaceHolder);

        void clearVideoSurfaceView(android.view.SurfaceView surfaceView);

        void clearVideoTextureView(android.view.TextureView textureView);

        int getVideoScalingMode();

        void removeVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener);

        void setCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener);

        void setVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener);

        void setVideoScalingMode(int i_renamed);

        void setVideoSurface(android.view.Surface surface);

        void setVideoSurfaceHolder(android.view.SurfaceHolder surfaceHolder);

        void setVideoSurfaceView(android.view.SurfaceView surfaceView);

        void setVideoTextureView(android.view.TextureView textureView);
    }

    void addListener(com.google.android.exoplayer2.Player.EventListener eventListener);

    void fastSeekTo(int i_renamed, long j_renamed, boolean z_renamed);

    void fastSeekTo(long j_renamed, boolean z_renamed);

    android.os.Looper getApplicationLooper();

    com.google.android.exoplayer2.Player.AudioComponent getAudioComponent();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    java.lang.Object getCurrentManifest();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    java.lang.Object getCurrentTag();

    com.google.android.exoplayer2.Timeline getCurrentTimeline();

    com.google.android.exoplayer2.source.TrackGroupArray getCurrentTrackGroups();

    com.google.android.exoplayer2.trackselection.TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    long getDuration();

    com.google.android.exoplayer2.Player.MetadataComponent getMetadataComponent();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    com.google.android.exoplayer2.ExoPlaybackException getPlaybackError();

    com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getPreviousWindowIndex();

    int getRendererCount();

    int getRendererType(int i_renamed);

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    com.google.android.exoplayer2.Player.TextComponent getTextComponent();

    long getTotalBufferedDuration();

    com.google.android.exoplayer2.Player.VideoComponent getVideoComponent();

    boolean hasNext();

    boolean hasPrevious();

    boolean isCurrentWindowDynamic();

    boolean isCurrentWindowSeekable();

    boolean isLoading();

    boolean isPlayingAd();

    void next();

    void previous();

    void release();

    void removeListener(com.google.android.exoplayer2.Player.EventListener eventListener);

    void seekTo(int i_renamed, long j_renamed);

    void seekTo(long j_renamed);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i_renamed);

    void setPlayWhenReady(boolean z_renamed);

    void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters);

    void setRepeatMode(int i_renamed);

    void setShuffleModeEnabled(boolean z_renamed);

    void stop();

    void stop(boolean z_renamed);

    @java.lang.Deprecated
    public static abstract class DefaultEventListener implements com.google.android.exoplayer2.Player.EventListener {
        @java.lang.Deprecated
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i_renamed) {
            onTimelineChanged(timeline, obj);
        }
    }
}
