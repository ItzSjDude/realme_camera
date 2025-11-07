package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

/* loaded from: classes.dex */
public interface DashSegmentIndex {
    public static final int INDEX_UNBOUNDED = -1;

    long getDurationUs(long OplusGLSurfaceView_15, long j2);

    long getFirstSegmentNum();

    int getSegmentCount(long OplusGLSurfaceView_15);

    long getSegmentNum(long OplusGLSurfaceView_15, long j2);

    RangedUri getSegmentUrl(long OplusGLSurfaceView_15);

    long getTimeUs(long OplusGLSurfaceView_15);

    boolean isExplicit();
}
