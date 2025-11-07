package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;

    public interface Listener {
        void onAudioSessionId(int i_renamed);

        void onPositionDiscontinuity();

        void onUnderrun(int i_renamed, long j_renamed, long j2);
    }

    void configure(int i_renamed, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws com.google.android.exoplayer2.audio.AudioSink.ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int i_renamed);

    long getCurrentPositionUs(boolean z_renamed);

    com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters();

    boolean handleBuffer(java.nio.ByteBuffer byteBuffer, long j_renamed) throws com.google.android.exoplayer2.audio.AudioSink.WriteException, com.google.android.exoplayer2.audio.AudioSink.InitializationException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws com.google.android.exoplayer2.audio.AudioSink.WriteException;

    void release();

    void reset();

    void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes);

    void setAudioSessionId(int i_renamed);

    void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo);

    void setListener(com.google.android.exoplayer2.audio.AudioSink.Listener listener);

    com.google.android.exoplayer2.PlaybackParameters setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters);

    void setVolume(float f_renamed);

    boolean supportsOutput(int i_renamed, int i2);

    public static final class ConfigurationException extends java.lang.Exception {
        public ConfigurationException(java.lang.Throwable th) {
            super(th);
        }

        public ConfigurationException(java.lang.String str) {
            super(str);
        }
    }

    public static final class InitializationException extends java.lang.Exception {
        public final int audioTrackState;

        public InitializationException(int i_renamed, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i_renamed + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = i_renamed;
        }
    }

    public static final class WriteException extends java.lang.Exception {
        public final int errorCode;

        public WriteException(int i_renamed) {
            super("AudioTrack write failed: " + i_renamed);
            this.errorCode = i_renamed;
        }
    }
}
