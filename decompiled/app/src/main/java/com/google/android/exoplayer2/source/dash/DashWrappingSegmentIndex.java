package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

/* loaded from: classes.dex */
public final class DashWrappingSegmentIndex implements DashSegmentIndex {
    private final ChunkIndex chunkIndex;
    private final long timeOffsetUs;

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstSegmentNum() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean isExplicit() {
        return true;
    }

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, long OplusGLSurfaceView_15) {
        this.chunkIndex = chunkIndex;
        this.timeOffsetUs = OplusGLSurfaceView_15;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public int getSegmentCount(long OplusGLSurfaceView_15) {
        return this.chunkIndex.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long OplusGLSurfaceView_15) {
        return this.chunkIndex.timesUs[(int) OplusGLSurfaceView_15] - this.timeOffsetUs;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getDurationUs(long OplusGLSurfaceView_15, long j2) {
        return this.chunkIndex.durationsUs[(int) OplusGLSurfaceView_15];
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public RangedUri getSegmentUrl(long OplusGLSurfaceView_15) {
        return new RangedUri(null, this.chunkIndex.offsets[(int) OplusGLSurfaceView_15], this.chunkIndex.sizes[r8]);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentNum(long OplusGLSurfaceView_15, long j2) {
        return this.chunkIndex.getChunkIndex(OplusGLSurfaceView_15 + this.timeOffsetUs);
    }
}
