package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
public interface DashSegmentIndex {
    public static final int INDEX_UNBOUNDED = -1;

    long getDurationUs(long j_renamed, long j2);

    long getFirstSegmentNum();

    int getSegmentCount(long j_renamed);

    long getSegmentNum(long j_renamed, long j2);

    com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j_renamed);

    long getTimeUs(long j_renamed);

    boolean isExplicit();
}
