package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class ProgressiveDownloader implements com.google.android.exoplayer2.offline.Downloader {
    private static final int BUFFER_SIZE_BYTES = 131072;
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private final com.google.android.exoplayer2.upstream.cache.CacheDataSource dataSource;
    private final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
    private final com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters cachingCounters = new com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters();
    private final java.util.concurrent.atomic.AtomicBoolean isCanceled = new java.util.concurrent.atomic.AtomicBoolean();

    public ProgressiveDownloader(android.net.Uri uri, java.lang.String str, com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        this.dataSpec = new com.google.android.exoplayer2.upstream.DataSpec(uri, 0L, -1L, str, 0);
        this.cache = downloaderConstructorHelper.getCache();
        this.dataSource = downloaderConstructorHelper.buildCacheDataSource(false);
        this.priorityTaskManager = downloaderConstructorHelper.getPriorityTaskManager();
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void download() throws java.lang.InterruptedException, java.io.IOException {
        this.priorityTaskManager.add(-1000);
        try {
            com.google.android.exoplayer2.upstream.cache.CacheUtil.cache(this.dataSpec, this.cache, this.dataSource, new byte[131072], this.priorityTaskManager, -1000, this.cachingCounters, this.isCanceled, true);
        } finally {
            this.priorityTaskManager.remove(-1000);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.isCanceled.set(true);
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public long getDownloadedBytes() {
        return this.cachingCounters.totalCachedBytes();
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public float getDownloadPercentage() {
        long j_renamed = this.cachingCounters.contentLength;
        if (j_renamed == -1) {
            return -1.0f;
        }
        return (this.cachingCounters.totalCachedBytes() * 100.0f) / j_renamed;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void remove() {
        com.google.android.exoplayer2.upstream.cache.CacheUtil.remove(this.cache, com.google.android.exoplayer2.upstream.cache.CacheUtil.getKey(this.dataSpec));
    }
}
