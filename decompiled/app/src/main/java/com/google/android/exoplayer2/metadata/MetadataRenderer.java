package com.google.android.exoplayer2.metadata;

/* loaded from: classes.dex */
public final class MetadataRenderer extends com.google.android.exoplayer2.BaseRenderer implements android.os.Handler.Callback {
    private static final int MAX_PENDING_METADATA_COUNT = 5;
    private static final int MSG_INVOKE_RENDERER = 0;
    private final com.google.android.exoplayer2.metadata.MetadataInputBuffer buffer;
    private com.google.android.exoplayer2.metadata.MetadataDecoder decoder;
    private final com.google.android.exoplayer2.metadata.MetadataDecoderFactory decoderFactory;
    private final com.google.android.exoplayer2.FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private final com.google.android.exoplayer2.metadata.MetadataOutput output;
    private final android.os.Handler outputHandler;
    private final com.google.android.exoplayer2.metadata.Metadata[] pendingMetadata;
    private int pendingMetadataCount;
    private int pendingMetadataIndex;
    private final long[] pendingMetadataTimestamps;

    @java.lang.Deprecated
    public interface Output extends com.google.android.exoplayer2.metadata.MetadataOutput {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    public MetadataRenderer(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, android.os.Looper looper) {
        this(metadataOutput, looper, com.google.android.exoplayer2.metadata.MetadataDecoderFactory.DEFAULT);
    }

    public MetadataRenderer(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, android.os.Looper looper, com.google.android.exoplayer2.metadata.MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        this.output = (com.google.android.exoplayer2.metadata.MetadataOutput) com.google.android.exoplayer2.util.Assertions.checkNotNull(metadataOutput);
        this.outputHandler = looper == null ? null : com.google.android.exoplayer2.util.Util.createHandler(looper, this);
        this.decoderFactory = (com.google.android.exoplayer2.metadata.MetadataDecoderFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(metadataDecoderFactory);
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
        this.buffer = new com.google.android.exoplayer2.metadata.MetadataInputBuffer();
        this.pendingMetadata = new com.google.android.exoplayer2.metadata.Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) {
        if (this.decoderFactory.supportsFormat(format)) {
            return supportsFormatDrm(null, format.drmInitData) ? 4 : 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) {
        flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (!this.inputStreamEnded && this.pendingMetadataCount < 5) {
            this.buffer.clear();
            if (readSource(this.formatHolder, this.buffer, false) == -4) {
                if (this.buffer.isEndOfStream()) {
                    this.inputStreamEnded = true;
                } else if (!this.buffer.isDecodeOnly()) {
                    this.buffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                    this.buffer.flip();
                    int i_renamed = (this.pendingMetadataIndex + this.pendingMetadataCount) % 5;
                    com.google.android.exoplayer2.metadata.Metadata metadataDecode = this.decoder.decode(this.buffer);
                    if (metadataDecode != null) {
                        this.pendingMetadata[i_renamed] = metadataDecode;
                        this.pendingMetadataTimestamps[i_renamed] = this.buffer.timeUs;
                        this.pendingMetadataCount++;
                    }
                }
            }
        }
        if (this.pendingMetadataCount > 0) {
            long[] jArr = this.pendingMetadataTimestamps;
            int i2 = this.pendingMetadataIndex;
            if (jArr[i2] <= j_renamed) {
                invokeRenderer(this.pendingMetadata[i2]);
                com.google.android.exoplayer2.metadata.Metadata[] metadataArr = this.pendingMetadata;
                int i3 = this.pendingMetadataIndex;
                metadataArr[i3] = null;
                this.pendingMetadataIndex = (i3 + 1) % 5;
                this.pendingMetadataCount--;
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        flushPendingMetadata();
        this.decoder = null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.inputStreamEnded;
    }

    private void invokeRenderer(com.google.android.exoplayer2.metadata.Metadata metadata) {
        android.os.Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void flushPendingMetadata() {
        java.util.Arrays.fill(this.pendingMetadata, (java.lang.Object) null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what == 0) {
            invokeRendererInternal((com.google.android.exoplayer2.metadata.Metadata) message.obj);
            return true;
        }
        throw new java.lang.IllegalStateException();
    }

    private void invokeRendererInternal(com.google.android.exoplayer2.metadata.Metadata metadata) {
        this.output.onMetadata(metadata);
    }
}
