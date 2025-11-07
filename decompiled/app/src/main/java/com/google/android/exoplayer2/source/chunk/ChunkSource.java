package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters);

    void getNextChunk(long j_renamed, long j2, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j_renamed, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list);

    void maybeThrowError() throws java.io.IOException;

    void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk);

    boolean onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, boolean z_renamed, java.lang.Exception exc, long j_renamed);
}
