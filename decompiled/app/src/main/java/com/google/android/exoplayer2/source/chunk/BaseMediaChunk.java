package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public abstract class BaseMediaChunk extends com.google.android.exoplayer2.source.chunk.MediaChunk {
    public final long clippedEndTimeUs;
    public final long clippedStartTimeUs;
    private int[] firstSampleIndices;
    private com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput output;

    public BaseMediaChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i_renamed, java.lang.Object obj, long j_renamed, long j2, long j3, long j4, long j5) {
        super(dataSource, dataSpec, format, i_renamed, obj, j_renamed, j2, j5);
        this.clippedStartTimeUs = j3;
        this.clippedEndTimeUs = j4;
    }

    public void init(com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput baseMediaChunkOutput) {
        this.output = baseMediaChunkOutput;
        this.firstSampleIndices = baseMediaChunkOutput.getWriteIndices();
    }

    public final int getFirstSampleIndex(int i_renamed) {
        return this.firstSampleIndices[i_renamed];
    }

    protected final com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput getOutput() {
        return this.output;
    }
}
