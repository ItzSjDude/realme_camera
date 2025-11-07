package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public final class InitializationChunk extends com.google.android.exoplayer2.source.chunk.Chunk {
    private static final com.google.android.exoplayer2.extractor.PositionHolder DUMMY_POSITION_HOLDER = new com.google.android.exoplayer2.extractor.PositionHolder();
    private final com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private long nextLoadPosition;

    public InitializationChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i_renamed, java.lang.Object obj, com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, 2, format, i_renamed, obj, -9223372036854775807L, -9223372036854775807L);
        this.extractorWrapper = chunkExtractorWrapper;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSpec dataSpecSubrange = this.dataSpec.subrange(this.nextLoadPosition);
        try {
            com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(this.dataSource, dataSpecSubrange.absoluteStreamPosition, this.dataSource.open(dataSpecSubrange));
            if (this.nextLoadPosition == 0) {
                this.extractorWrapper.init(null, -9223372036854775807L, -9223372036854775807L);
            }
            try {
                com.google.android.exoplayer2.extractor.Extractor extractor = this.extractorWrapper.extractor;
                int i_renamed = 0;
                while (i_renamed == 0 && !this.loadCanceled) {
                    i_renamed = extractor.read(defaultExtractorInput, DUMMY_POSITION_HOLDER);
                }
                boolean z_renamed = true;
                if (i_renamed == 1) {
                    z_renamed = false;
                }
                com.google.android.exoplayer2.util.Assertions.checkState(z_renamed);
            } finally {
                this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition;
            }
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
        }
    }
}
