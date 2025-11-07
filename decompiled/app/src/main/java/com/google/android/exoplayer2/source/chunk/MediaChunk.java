package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public abstract class MediaChunk extends com.google.android.exoplayer2.source.chunk.Chunk {
    public final long chunkIndex;

    public abstract boolean isLoadCompleted();

    public MediaChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i_renamed, java.lang.Object obj, long j_renamed, long j2, long j3) {
        super(dataSource, dataSpec, 1, format, i_renamed, obj, j_renamed, j2);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(format);
        this.chunkIndex = j3;
    }

    public long getNextChunkIndex() {
        long j_renamed = this.chunkIndex;
        if (j_renamed != -1) {
            return 1 + j_renamed;
        }
        return -1L;
    }
}
