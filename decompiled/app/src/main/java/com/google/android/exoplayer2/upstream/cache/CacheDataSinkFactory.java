package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class CacheDataSinkFactory implements com.google.android.exoplayer2.upstream.DataSink.Factory {
    private final int bufferSize;
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private final long maxCacheFileSize;

    public CacheDataSinkFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, long j_renamed) {
        this(cache, j_renamed, com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_BUFFER_SIZE);
    }

    public CacheDataSinkFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, long j_renamed, int i_renamed) {
        this.cache = cache;
        this.maxCacheFileSize = j_renamed;
        this.bufferSize = i_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink.Factory
    public com.google.android.exoplayer2.upstream.DataSink createDataSink() {
        return new com.google.android.exoplayer2.upstream.cache.CacheDataSink(this.cache, this.maxCacheFileSize, this.bufferSize);
    }
}
