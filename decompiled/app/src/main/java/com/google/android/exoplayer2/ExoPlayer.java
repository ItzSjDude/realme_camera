package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public interface ExoPlayer extends com.google.android.exoplayer2.Player {

    @java.lang.Deprecated
    public static final int REPEAT_MODE_ALL = 2;

    @java.lang.Deprecated
    public static final int REPEAT_MODE_OFF = 0;

    @java.lang.Deprecated
    public static final int REPEAT_MODE_ONE = 1;

    @java.lang.Deprecated
    public static final int STATE_BUFFERING = 2;

    @java.lang.Deprecated
    public static final int STATE_ENDED = 4;

    @java.lang.Deprecated
    public static final int STATE_IDLE = 1;

    @java.lang.Deprecated
    public static final int STATE_READY = 3;

    @java.lang.Deprecated
    public interface EventListener extends com.google.android.exoplayer2.Player.EventListener {
    }

    @java.lang.Deprecated
    public interface ExoPlayerComponent extends com.google.android.exoplayer2.PlayerMessage.Target {
    }

    @java.lang.Deprecated
    void blockingSendMessages(com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr);

    com.google.android.exoplayer2.PlayerMessage createMessage(com.google.android.exoplayer2.PlayerMessage.Target target);

    android.os.Looper getPlaybackLooper();

    com.google.android.exoplayer2.SeekParameters getSeekParameters();

    void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource);

    void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z_renamed, boolean z2);

    void retry();

    @java.lang.Deprecated
    void sendMessages(com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr);

    void setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters);

    @java.lang.Deprecated
    public static final class ExoPlayerMessage {
        public final java.lang.Object message;
        public final int messageType;
        public final com.google.android.exoplayer2.PlayerMessage.Target target;

        @java.lang.Deprecated
        public ExoPlayerMessage(com.google.android.exoplayer2.PlayerMessage.Target target, int i_renamed, java.lang.Object obj) {
            this.target = target;
            this.messageType = i_renamed;
            this.message = obj;
        }
    }
}
