package com.google.android.exoplayer2;

/* loaded from: classes.dex */
final class DefaultMediaClock implements com.google.android.exoplayer2.util.MediaClock {
    private final com.google.android.exoplayer2.DefaultMediaClock.PlaybackParameterListener listener;
    private com.google.android.exoplayer2.util.MediaClock rendererClock;
    private com.google.android.exoplayer2.Renderer rendererClockSource;
    private final com.google.android.exoplayer2.util.StandaloneMediaClock standaloneMediaClock;

    public interface PlaybackParameterListener {
        void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(com.google.android.exoplayer2.DefaultMediaClock.PlaybackParameterListener playbackParameterListener, com.google.android.exoplayer2.util.Clock clock) {
        this.listener = playbackParameterListener;
        this.standaloneMediaClock = new com.google.android.exoplayer2.util.StandaloneMediaClock(clock);
    }

    public void start() {
        this.standaloneMediaClock.start();
    }

    public void stop() {
        this.standaloneMediaClock.stop();
    }

    public void resetPosition(long j_renamed) {
        this.standaloneMediaClock.resetPosition(j_renamed);
    }

    public void onRendererEnabled(com.google.android.exoplayer2.Renderer renderer) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.MediaClock mediaClock;
        com.google.android.exoplayer2.util.MediaClock mediaClock2 = renderer.getMediaClock();
        if (mediaClock2 == null || mediaClock2 == (mediaClock = this.rendererClock)) {
            return;
        }
        if (mediaClock != null) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForUnexpected(new java.lang.IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.rendererClock = mediaClock2;
        this.rendererClockSource = renderer;
        this.rendererClock.setPlaybackParameters(this.standaloneMediaClock.getPlaybackParameters());
        ensureSynced();
    }

    public void onRendererDisabled(com.google.android.exoplayer2.Renderer renderer) {
        if (renderer == this.rendererClockSource) {
            this.rendererClock = null;
            this.rendererClockSource = null;
        }
    }

    public long syncAndGetPositionUs() {
        if (isUsingRendererClock()) {
            ensureSynced();
            return this.rendererClock.getPositionUs();
        }
        return this.standaloneMediaClock.getPositionUs();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (isUsingRendererClock()) {
            return this.rendererClock.getPositionUs();
        }
        return this.standaloneMediaClock.getPositionUs();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        com.google.android.exoplayer2.util.MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            playbackParameters = mediaClock.setPlaybackParameters(playbackParameters);
        }
        this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
        this.listener.onPlaybackParametersChanged(playbackParameters);
        return playbackParameters;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        com.google.android.exoplayer2.util.MediaClock mediaClock = this.rendererClock;
        return mediaClock != null ? mediaClock.getPlaybackParameters() : this.standaloneMediaClock.getPlaybackParameters();
    }

    private void ensureSynced() {
        this.standaloneMediaClock.resetPosition(this.rendererClock.getPositionUs());
        com.google.android.exoplayer2.PlaybackParameters playbackParameters = this.rendererClock.getPlaybackParameters();
        if (playbackParameters.equals(this.standaloneMediaClock.getPlaybackParameters())) {
            return;
        }
        this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
        this.listener.onPlaybackParametersChanged(playbackParameters);
    }

    private boolean isUsingRendererClock() {
        com.google.android.exoplayer2.Renderer renderer = this.rendererClockSource;
        return (renderer == null || renderer.isEnded() || (!this.rendererClockSource.isReady() && this.rendererClockSource.hasReadStreamToEnd())) ? false : true;
    }
}
