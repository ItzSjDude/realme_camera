package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes.dex */
public class CameraMotionRenderer extends com.google.android.exoplayer2.BaseRenderer {
    private static final int SAMPLE_WINDOW_DURATION_US = 100000;
    private final com.google.android.exoplayer2.decoder.DecoderInputBuffer buffer;
    private final com.google.android.exoplayer2.FormatHolder formatHolder;
    private long lastTimestampUs;
    private com.google.android.exoplayer2.video.spherical.CameraMotionListener listener;
    private long offsetUs;
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch;

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    public CameraMotionRenderer() {
        super(5);
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
        this.buffer = new com.google.android.exoplayer2.decoder.DecoderInputBuffer(1);
        this.scratch = new com.google.android.exoplayer2.util.ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) {
        return com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CAMERA_MOTION.equals(format.sampleMimeType) ? 4 : 0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i_renamed == 7) {
            this.listener = (com.google.android.exoplayer2.video.spherical.CameraMotionListener) obj;
        } else {
            super.handleMessage(i_renamed, obj);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.offsetUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        reset();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        reset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        float[] metadata;
        while (!hasReadStreamToEnd() && this.lastTimestampUs < 100000 + j_renamed) {
            this.buffer.clear();
            if (readSource(this.formatHolder, this.buffer, false) != -4 || this.buffer.isEndOfStream()) {
                return;
            }
            this.buffer.flip();
            this.lastTimestampUs = this.buffer.timeUs;
            if (this.listener != null && (metadata = parseMetadata(this.buffer.data)) != null) {
                ((com.google.android.exoplayer2.video.spherical.CameraMotionListener) com.google.android.exoplayer2.util.Util.castNonNull(this.listener)).onCameraMotion(this.lastTimestampUs - this.offsetUs, metadata);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    private float[] parseMetadata(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.scratch.reset(byteBuffer.array(), byteBuffer.limit());
        this.scratch.setPosition(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i_renamed = 0; i_renamed < 3; i_renamed++) {
            fArr[i_renamed] = java.lang.Float.intBitsToFloat(this.scratch.readLittleEndianInt());
        }
        return fArr;
    }

    private void reset() {
        this.lastTimestampUs = 0L;
        com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener = this.listener;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }
}
