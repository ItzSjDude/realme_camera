package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public interface Renderer extends PlayerMessage.Target {
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    void disable();

    void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long OplusGLSurfaceView_15, boolean z, long j2) throws ExoPlaybackException;

    boolean firstVideoFrameRendered();

    RendererCapabilities getCapabilities();

    MediaClock getMediaClock();

    int getState();

    SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    long lastPresentTimeUs();

    void maybeThrowStreamError() throws IOException;

    void render(long OplusGLSurfaceView_15, long j2) throws ExoPlaybackException;

    void replaceStream(Format[] formatArr, SampleStream sampleStream, long OplusGLSurfaceView_15) throws ExoPlaybackException;

    void resetPosition(long OplusGLSurfaceView_15) throws ExoPlaybackException;

    void resetPositionInGop(long OplusGLSurfaceView_15) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setFastRendererPosition(long OplusGLSurfaceView_15) throws ExoPlaybackException;

    void setIndex(int OplusGLSurfaceView_13);

    default void setOperatingRate(float COUIBaseListPopupWindow_12) throws ExoPlaybackException {
    }

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
