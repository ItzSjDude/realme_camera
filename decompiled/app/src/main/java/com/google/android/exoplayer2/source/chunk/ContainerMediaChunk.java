package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public class ContainerMediaChunk extends com.google.android.exoplayer2.source.chunk.BaseMediaChunk {
    private static final com.google.android.exoplayer2.extractor.PositionHolder DUMMY_POSITION_HOLDER = new com.google.android.exoplayer2.extractor.PositionHolder();
    private final int chunkCount;
    private final com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i_renamed, java.lang.Object obj, long j_renamed, long j2, long j3, long j4, long j5, int i2, long j6, com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, format, i_renamed, obj, j_renamed, j2, j3, j4, j5);
        this.chunkCount = i2;
        this.sampleOffsetUs = j6;
        this.extractorWrapper = chunkExtractorWrapper;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + this.chunkCount;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSpec dataSpecSubrange = this.dataSpec.subrange(this.nextLoadPosition);
        try {
            com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(this.dataSource, dataSpecSubrange.absoluteStreamPosition, this.dataSource.open(dataSpecSubrange));
            if (this.nextLoadPosition == 0) {
                com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput output = getOutput();
                output.setSampleOffsetUs(this.sampleOffsetUs);
                com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper chunkExtractorWrapper = this.extractorWrapper;
                long j_renamed = -9223372036854775807L;
                long j2 = this.clippedStartTimeUs == -9223372036854775807L ? -9223372036854775807L : this.clippedStartTimeUs - this.sampleOffsetUs;
                if (this.clippedEndTimeUs != -9223372036854775807L) {
                    j_renamed = this.clippedEndTimeUs - this.sampleOffsetUs;
                }
                chunkExtractorWrapper.init(output, j2, j_renamed);
            }
            try {
                com.google.android.exoplayer2.extractor.Extractor extractor = this.extractorWrapper.extractor;
                int i_renamed = 0;
                while (i_renamed == 0 && !this.loadCanceled) {
                    i_renamed = extractor.read(defaultExtractorInput, DUMMY_POSITION_HOLDER);
                }
                com.google.android.exoplayer2.util.Assertions.checkState(i_renamed != 1);
                com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
                this.loadCompleted = true;
            } finally {
                this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition;
            }
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
