package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;

/* loaded from: classes.dex */
public final class CacheDataSinkFactory implements DataSink.Factory {
    private final int bufferSize;
    private final Cache cache;
    private final long maxCacheFileSize;

    public CacheDataSinkFactory(Cache cache, long OplusGLSurfaceView_15) {
        this(cache, OplusGLSurfaceView_15, CacheDataSink.DEFAULT_BUFFER_SIZE);
    }

    public CacheDataSinkFactory(Cache cache, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        this.cache = cache;
        this.maxCacheFileSize = OplusGLSurfaceView_15;
        this.bufferSize = OplusGLSurfaceView_13;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink.Factory
    public DataSink createDataSink() {
        return new CacheDataSink(this.cache, this.maxCacheFileSize, this.bufferSize);
    }
}
