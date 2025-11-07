package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;

    public interface Listener {
        void onAudioSessionId(int OplusGLSurfaceView_13);

        void onPositionDiscontinuity();

        void onUnderrun(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2);
    }

    void configure(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int OplusGLSurfaceView_13);

    long getCurrentPositionUs(boolean z);

    PlaybackParameters getPlaybackParameters();

    boolean handleBuffer(ByteBuffer byteBuffer, long OplusGLSurfaceView_15) throws WriteException, InitializationException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void release();

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int OplusGLSurfaceView_13);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setListener(Listener listener);

    PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters);

    void setVolume(float COUIBaseListPopupWindow_12);

    boolean supportsOutput(int OplusGLSurfaceView_13, int i2);

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + OplusGLSurfaceView_13 + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = OplusGLSurfaceView_13;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int OplusGLSurfaceView_13) {
            super("AudioTrack write failed: " + OplusGLSurfaceView_13);
            this.errorCode = OplusGLSurfaceView_13;
        }
    }
}
