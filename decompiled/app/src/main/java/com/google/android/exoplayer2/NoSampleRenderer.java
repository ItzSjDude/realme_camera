package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public abstract class NoSampleRenderer implements com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities {
    private com.google.android.exoplayer2.RendererConfiguration configuration;
    private int index;
    private int state;
    private com.google.android.exoplayer2.source.SampleStream stream;
    private boolean streamIsFinal;

    @Override // com.google.android.exoplayer2.Renderer
    public final com.google.android.exoplayer2.RendererCapabilities getCapabilities() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return 6;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws java.io.IOException {
    }

    protected void onDisabled() {
    }

    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onRendererOffsetChanged(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onStarted() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onStopped() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws com.google.android.exoplayer2.ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setIndex(int i_renamed) {
        this.index = i_renamed;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(com.google.android.exoplayer2.RendererConfiguration rendererConfiguration, com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j_renamed, boolean z_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z_renamed);
        replaceStream(formatArr, sampleStream, j2);
        onPositionReset(j_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        onRendererOffsetChanged(j_renamed);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final com.google.android.exoplayer2.source.SampleStream getStream() {
        return this.stream;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.streamIsFinal = false;
        onPositionReset(j_renamed, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.state == 1);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    protected final com.google.android.exoplayer2.RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    protected final int getIndex() {
        return this.index;
    }
}
