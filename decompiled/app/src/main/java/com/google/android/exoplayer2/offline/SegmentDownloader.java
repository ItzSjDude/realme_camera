package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public abstract class SegmentDownloader<M_renamed extends com.google.android.exoplayer2.offline.FilterableManifest<M_renamed>> implements com.google.android.exoplayer2.offline.Downloader {
    private static final int BUFFER_SIZE_BYTES = 131072;
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private final com.google.android.exoplayer2.upstream.cache.CacheDataSource dataSource;
    private volatile long downloadedBytes;
    private volatile int downloadedSegments;
    private final android.net.Uri manifestUri;
    private final com.google.android.exoplayer2.upstream.cache.CacheDataSource offlineDataSource;
    private final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
    private final java.util.ArrayList<com.google.android.exoplayer2.offline.StreamKey> streamKeys;
    private volatile int totalSegments = -1;
    private final java.util.concurrent.atomic.AtomicBoolean isCanceled = new java.util.concurrent.atomic.AtomicBoolean();

    protected abstract M_renamed getManifest(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri) throws java.io.IOException;

    protected abstract java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> getSegments(com.google.android.exoplayer2.upstream.DataSource dataSource, M_renamed m_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException;

    protected static class Segment implements java.lang.Comparable<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> {
        public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j_renamed, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            this.startTimeUs = j_renamed;
            this.dataSpec = dataSpec;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.offline.SegmentDownloader.Segment segment) {
            return com.google.android.exoplayer2.util.Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public SegmentDownloader(android.net.Uri uri, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        this.manifestUri = uri;
        this.streamKeys = new java.util.ArrayList<>(list);
        this.cache = downloaderConstructorHelper.getCache();
        this.dataSource = downloaderConstructorHelper.buildCacheDataSource(false);
        this.offlineDataSource = downloaderConstructorHelper.buildCacheDataSource(true);
        this.priorityTaskManager = downloaderConstructorHelper.getPriorityTaskManager();
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void download() throws java.lang.InterruptedException, java.io.IOException {
        this.priorityTaskManager.add(-1000);
        try {
            java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> listInitDownload = initDownload();
            java.util.Collections.sort(listInitDownload);
            byte[] bArr = new byte[131072];
            com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters cachingCounters = new com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters();
            for (int i_renamed = 0; i_renamed < listInitDownload.size(); i_renamed++) {
                try {
                    com.google.android.exoplayer2.upstream.cache.CacheUtil.cache(listInitDownload.get(i_renamed).dataSpec, this.cache, this.dataSource, bArr, this.priorityTaskManager, -1000, cachingCounters, this.isCanceled, true);
                    this.downloadedSegments++;
                    this.downloadedBytes += cachingCounters.newlyCachedBytes;
                } finally {
                }
            }
        } finally {
            this.priorityTaskManager.remove(-1000);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.isCanceled.set(true);
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final float getDownloadPercentage() {
        int i_renamed = this.totalSegments;
        int i2 = this.downloadedSegments;
        if (i_renamed == -1 || i2 == -1) {
            return -1.0f;
        }
        if (i_renamed == 0) {
            return 100.0f;
        }
        return (i2 * 100.0f) / i_renamed;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() throws java.lang.InterruptedException {
        try {
            java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> segments = getSegments(this.offlineDataSource, getManifest(this.offlineDataSource, this.manifestUri), true);
            for (int i_renamed = 0; i_renamed < segments.size(); i_renamed++) {
                removeUri(segments.get(i_renamed).dataSpec.uri);
            }
        } catch (java.io.IOException unused) {
        } catch (java.lang.Throwable th) {
            removeUri(this.manifestUri);
            throw th;
        }
        removeUri(this.manifestUri);
    }

    private java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> initDownload() throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.offline.FilterableManifest manifest = getManifest(this.dataSource, this.manifestUri);
        if (!this.streamKeys.isEmpty()) {
            manifest = (com.google.android.exoplayer2.offline.FilterableManifest) manifest.copy(this.streamKeys);
        }
        java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> segments = getSegments(this.dataSource, manifest, false);
        com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters cachingCounters = new com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters();
        this.totalSegments = segments.size();
        this.downloadedSegments = 0;
        this.downloadedBytes = 0L;
        for (int size = segments.size() - 1; size >= 0; size--) {
            com.google.android.exoplayer2.upstream.cache.CacheUtil.getCached(segments.get(size).dataSpec, this.cache, cachingCounters);
            this.downloadedBytes += cachingCounters.alreadyCachedBytes;
            if (cachingCounters.alreadyCachedBytes == cachingCounters.contentLength) {
                this.downloadedSegments++;
                segments.remove(size);
            }
        }
        return segments;
    }

    private void removeUri(android.net.Uri uri) {
        com.google.android.exoplayer2.upstream.cache.CacheUtil.remove(this.cache, com.google.android.exoplayer2.upstream.cache.CacheUtil.generateKey(uri));
    }
}
