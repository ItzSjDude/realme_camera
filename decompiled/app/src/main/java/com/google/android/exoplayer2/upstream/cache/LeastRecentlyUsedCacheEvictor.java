package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class LeastRecentlyUsedCacheEvictor implements com.google.android.exoplayer2.upstream.cache.CacheEvictor, java.util.Comparator<com.google.android.exoplayer2.upstream.cache.CacheSpan> {
    private long currentSize;
    private final java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> leastRecentlyUsed = new java.util.TreeSet<>(this);
    private final long maxBytes;

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    public LeastRecentlyUsedCacheEvictor(long j_renamed) {
        this.maxBytes = j_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(com.google.android.exoplayer2.upstream.cache.Cache cache, java.lang.String str, long j_renamed, long j2) {
        evictCache(cache, j2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanAdded(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        this.currentSize += cacheSpan.length;
        evictCache(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanRemoved(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        this.currentSize -= cacheSpan.length;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    @Override // java.util.Comparator
    public int compare(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2) {
        if (cacheSpan.lastAccessTimestamp - cacheSpan2.lastAccessTimestamp == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return cacheSpan.lastAccessTimestamp < cacheSpan2.lastAccessTimestamp ? -1 : 1;
    }

    private void evictCache(com.google.android.exoplayer2.upstream.cache.Cache cache, long j_renamed) {
        while (this.currentSize + j_renamed > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            try {
                cache.removeSpan(this.leastRecentlyUsed.first());
            } catch (com.google.android.exoplayer2.upstream.cache.Cache.CacheException unused) {
            }
        }
    }
}
