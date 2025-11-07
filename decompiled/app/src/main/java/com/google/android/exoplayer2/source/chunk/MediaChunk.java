package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public abstract class MediaChunk extends Chunk {
    public final long chunkIndex;

    public abstract boolean isLoadCompleted();

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int OplusGLSurfaceView_13, Object obj, long OplusGLSurfaceView_15, long j2, long j3) {
        super(dataSource, dataSpec, 1, format, OplusGLSurfaceView_13, obj, OplusGLSurfaceView_15, j2);
        Assertions.checkNotNull(format);
        this.chunkIndex = j3;
    }

    public long getNextChunkIndex() {
        long OplusGLSurfaceView_15 = this.chunkIndex;
        if (OplusGLSurfaceView_15 != -1) {
            return 1 + OplusGLSurfaceView_15;
        }
        return -1L;
    }
}
