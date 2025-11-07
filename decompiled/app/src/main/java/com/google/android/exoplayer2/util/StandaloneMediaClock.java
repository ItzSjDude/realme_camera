package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class StandaloneMediaClock implements com.google.android.exoplayer2.util.MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final com.google.android.exoplayer2.util.Clock clock;
    private com.google.android.exoplayer2.PlaybackParameters playbackParameters = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
    private boolean started;

    public StandaloneMediaClock(com.google.android.exoplayer2.util.Clock clock) {
        this.clock = clock;
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.baseElapsedMs = this.clock.elapsedRealtime();
        this.started = true;
    }

    public void stop() {
        if (this.started) {
            resetPosition(getPositionUs());
            this.started = false;
        }
    }

    public void resetPosition(long j_renamed) {
        this.baseUs = j_renamed;
        if (this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long mediaTimeUsForPlayoutTimeMs;
        long j_renamed = this.baseUs;
        if (!this.started) {
            return j_renamed;
        }
        long jElapsedRealtime = this.clock.elapsedRealtime() - this.baseElapsedMs;
        if (this.playbackParameters.speed == 1.0f) {
            mediaTimeUsForPlayoutTimeMs = com.google.android.exoplayer2.C_renamed.msToUs(jElapsedRealtime);
        } else {
            mediaTimeUsForPlayoutTimeMs = this.playbackParameters.getMediaTimeUsForPlayoutTimeMs(jElapsedRealtime);
        }
        return j_renamed + mediaTimeUsForPlayoutTimeMs;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        if (this.started) {
            resetPosition(getPositionUs());
        }
        this.playbackParameters = playbackParameters;
        return playbackParameters;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }
}
