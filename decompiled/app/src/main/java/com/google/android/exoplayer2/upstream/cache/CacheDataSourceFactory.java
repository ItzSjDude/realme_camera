package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class CacheDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory cacheReadDataSourceFactory;
    private final com.google.android.exoplayer2.upstream.DataSink.Factory cacheWriteDataSinkFactory;
    private final com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener;
    private final int flags;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory upstreamFactory;

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this(cache, factory, 0);
    }

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, int i_renamed) {
        this(cache, factory, i_renamed, 2097152L);
    }

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, int i_renamed, long j_renamed) {
        this(cache, factory, new com.google.android.exoplayer2.upstream.FileDataSourceFactory(), new com.google.android.exoplayer2.upstream.cache.CacheDataSinkFactory(cache, j_renamed), i_renamed, null);
    }

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.DataSource.Factory factory2, com.google.android.exoplayer2.upstream.DataSink.Factory factory3, int i_renamed, com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener) {
        this.cache = cache;
        this.upstreamFactory = factory;
        this.cacheReadDataSourceFactory = factory2;
        this.cacheWriteDataSinkFactory = factory3;
        this.flags = i_renamed;
        this.eventListener = eventListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSource() {
        com.google.android.exoplayer2.upstream.cache.Cache cache = this.cache;
        com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource = this.upstreamFactory.createDataSource();
        com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource2 = this.cacheReadDataSourceFactory.createDataSource();
        com.google.android.exoplayer2.upstream.DataSink.Factory factory = this.cacheWriteDataSinkFactory;
        return new com.google.android.exoplayer2.upstream.cache.CacheDataSource(cache, dataSourceCreateDataSource, dataSourceCreateDataSource2, factory != null ? factory.createDataSink() : null, this.flags, this.eventListener);
    }
}
