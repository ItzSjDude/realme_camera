package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
public final class DashWrappingSegmentIndex implements com.google.android.exoplayer2.source.dash.DashSegmentIndex {
    private final com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex;
    private final long timeOffsetUs;

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstSegmentNum() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean isExplicit() {
        return true;
    }

    public DashWrappingSegmentIndex(com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex, long j_renamed) {
        this.chunkIndex = chunkIndex;
        this.timeOffsetUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public int getSegmentCount(long j_renamed) {
        return this.chunkIndex.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long j_renamed) {
        return this.chunkIndex.timesUs[(int) j_renamed] - this.timeOffsetUs;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getDurationUs(long j_renamed, long j2) {
        return this.chunkIndex.durationsUs[(int) j_renamed];
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j_renamed) {
        return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, this.chunkIndex.offsets[(int) j_renamed], this.chunkIndex.sizes[r8]);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentNum(long j_renamed, long j2) {
        return this.chunkIndex.getChunkIndex(j_renamed + this.timeOffsetUs);
    }
}
