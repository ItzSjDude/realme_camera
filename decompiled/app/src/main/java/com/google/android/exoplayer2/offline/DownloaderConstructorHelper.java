package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class DownloaderConstructorHelper {
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory cacheReadDataSourceFactory;
    private final com.google.android.exoplayer2.upstream.DataSink.Factory cacheWriteDataSinkFactory;
    private final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory upstreamDataSourceFactory;

    public DownloaderConstructorHelper(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this(cache, factory, null, null, null);
    }

    public DownloaderConstructorHelper(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.DataSource.Factory factory2, com.google.android.exoplayer2.upstream.DataSink.Factory factory3, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
        this.cache = cache;
        this.upstreamDataSourceFactory = factory;
        this.cacheReadDataSourceFactory = factory2;
        this.cacheWriteDataSinkFactory = factory3;
        this.priorityTaskManager = priorityTaskManager;
    }

    public com.google.android.exoplayer2.upstream.cache.Cache getCache() {
        return this.cache;
    }

    public com.google.android.exoplayer2.util.PriorityTaskManager getPriorityTaskManager() {
        com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        return priorityTaskManager != null ? priorityTaskManager : new com.google.android.exoplayer2.util.PriorityTaskManager();
    }

    public com.google.android.exoplayer2.upstream.cache.CacheDataSource buildCacheDataSource(boolean z_renamed) {
        com.google.android.exoplayer2.upstream.DataSource.Factory factory = this.cacheReadDataSourceFactory;
        com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource = factory != null ? factory.createDataSource() : new com.google.android.exoplayer2.upstream.FileDataSource();
        if (z_renamed) {
            return new com.google.android.exoplayer2.upstream.cache.CacheDataSource(this.cache, com.google.android.exoplayer2.upstream.DummyDataSource.INSTANCE, dataSourceCreateDataSource, null, 1, null);
        }
        com.google.android.exoplayer2.upstream.DataSink.Factory factory2 = this.cacheWriteDataSinkFactory;
        com.google.android.exoplayer2.upstream.DataSink dataSinkCreateDataSink = factory2 != null ? factory2.createDataSink() : new com.google.android.exoplayer2.upstream.cache.CacheDataSink(this.cache, 2097152L);
        com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource2 = this.upstreamDataSourceFactory.createDataSource();
        com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        return new com.google.android.exoplayer2.upstream.cache.CacheDataSource(this.cache, priorityTaskManager == null ? dataSourceCreateDataSource2 : new com.google.android.exoplayer2.upstream.PriorityDataSource(dataSourceCreateDataSource2, priorityTaskManager, -1000), dataSourceCreateDataSource, dataSinkCreateDataSink, 1, null);
    }
}
