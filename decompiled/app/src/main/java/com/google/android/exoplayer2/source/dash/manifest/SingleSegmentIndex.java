package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
final class SingleSegmentIndex implements com.google.android.exoplayer2.source.dash.DashSegmentIndex {
    private final com.google.android.exoplayer2.source.dash.manifest.RangedUri uri;

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getDurationUs(long j_renamed, long j2) {
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstSegmentNum() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public int getSegmentCount(long j_renamed) {
        return 1;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentNum(long j_renamed, long j2) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long j_renamed) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean isExplicit() {
        return true;
    }

    public SingleSegmentIndex(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri) {
        this.uri = rangedUri;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j_renamed) {
        return this.uri;
    }
}
