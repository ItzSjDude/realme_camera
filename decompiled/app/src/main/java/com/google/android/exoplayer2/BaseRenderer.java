package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public abstract class BaseRenderer implements com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities {
    private com.google.android.exoplayer2.RendererConfiguration configuration;
    private int index;
    private boolean readEndOfStream = true;
    private int state;
    private com.google.android.exoplayer2.source.SampleStream stream;
    private com.google.android.exoplayer2.Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private final int trackType;

    @Override // com.google.android.exoplayer2.Renderer
    public final com.google.android.exoplayer2.RendererCapabilities getCapabilities() {
        return this;
    }

    protected long getLastPresentTimeUs() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return null;
    }

    protected boolean getRenderedFirstFrame() {
        return true;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onDisabled() {
    }

    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onPositionResetInGop(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onSetFastRendererPosition(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onStarted() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onStopped() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws com.google.android.exoplayer2.ExoPlaybackException {
        return 0;
    }

    public BaseRenderer(int i_renamed) {
        this.trackType = i_renamed;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return this.trackType;
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
        this.readEndOfStream = false;
        this.streamFormats = formatArr;
        this.streamOffsetUs = j_renamed;
        onStreamChanged(formatArr, j_renamed);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final com.google.android.exoplayer2.source.SampleStream getStream() {
        return this.stream;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.readEndOfStream;
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
    public final void maybeThrowStreamError() throws java.io.IOException {
        this.stream.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.streamIsFinal = false;
        this.readEndOfStream = false;
        onPositionReset(j_renamed, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPositionInGop(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        onPositionResetInGop(j_renamed, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setFastRendererPosition(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        onSetFastRendererPosition(j_renamed, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean firstVideoFrameRendered() {
        return getRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final long lastPresentTimeUs() {
        return getLastPresentTimeUs();
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
        this.streamFormats = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    protected final com.google.android.exoplayer2.Format[] getStreamFormats() {
        return this.streamFormats;
    }

    protected final com.google.android.exoplayer2.RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    protected final int getIndex() {
        return this.index;
    }

    protected final int readSource(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
        int data = this.stream.readData(formatHolder, decoderInputBuffer, z_renamed);
        if (data == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.readEndOfStream = true;
                return this.streamIsFinal ? -4 : -3;
            }
            decoderInputBuffer.timeUs += this.streamOffsetUs;
        } else if (data == -5) {
            com.google.android.exoplayer2.Format format = formatHolder.format;
            if (format.subsampleOffsetUs != Long.MAX_VALUE) {
                formatHolder.format = format.copyWithSubsampleOffsetUs(format.subsampleOffsetUs + this.streamOffsetUs);
            }
        }
        return data;
    }

    protected int skipSource(long j_renamed) {
        return this.stream.skipData(j_renamed - this.streamOffsetUs);
    }

    protected final boolean isSourceReady() {
        return this.readEndOfStream ? this.streamIsFinal : this.stream.isReady();
    }

    protected static boolean supportsFormatDrm(com.google.android.exoplayer2.drm.DrmSessionManager<?> drmSessionManager, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (drmSessionManager == null) {
            return false;
        }
        return drmSessionManager.canAcquireSession(drmInitData);
    }
}
