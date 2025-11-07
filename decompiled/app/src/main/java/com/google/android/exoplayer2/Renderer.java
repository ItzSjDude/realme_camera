package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public interface Renderer extends com.google.android.exoplayer2.PlayerMessage.Target {
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    void disable();

    void enable(com.google.android.exoplayer2.RendererConfiguration rendererConfiguration, com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j_renamed, boolean z_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException;

    boolean firstVideoFrameRendered();

    com.google.android.exoplayer2.RendererCapabilities getCapabilities();

    com.google.android.exoplayer2.util.MediaClock getMediaClock();

    int getState();

    com.google.android.exoplayer2.source.SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    long lastPresentTimeUs();

    void maybeThrowStreamError() throws java.io.IOException;

    void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException;

    void replaceStream(com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException;

    void resetPosition(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException;

    void resetPositionInGop(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException;

    void setCurrentStreamFinal();

    void setFastRendererPosition(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException;

    void setIndex(int i_renamed);

    default void setOperatingRate(float f_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    void start() throws com.google.android.exoplayer2.ExoPlaybackException;

    void stop() throws com.google.android.exoplayer2.ExoPlaybackException;
}
