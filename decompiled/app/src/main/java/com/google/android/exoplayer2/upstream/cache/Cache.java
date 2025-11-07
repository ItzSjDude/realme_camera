package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public interface Cache {

    public interface Listener {
        void onSpanAdded(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan);

        void onSpanRemoved(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan);

        void onSpanTouched(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2);
    }

    java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> addListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener);

    void applyContentMetadataMutations(java.lang.String str, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    void commitFile(java.io.File file) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    long getCacheSpace();

    long getCachedLength(java.lang.String str, long j_renamed, long j2);

    java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> getCachedSpans(java.lang.String str);

    long getContentLength(java.lang.String str);

    com.google.android.exoplayer2.upstream.cache.ContentMetadata getContentMetadata(java.lang.String str);

    java.util.Set<java.lang.String> getKeys();

    boolean isCached(java.lang.String str, long j_renamed, long j2);

    void release();

    void releaseHoleSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan);

    void removeListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener);

    void removeSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    void setContentLength(java.lang.String str, long j_renamed) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    java.io.File startFile(java.lang.String str, long j_renamed, long j2) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWrite(java.lang.String str, long j_renamed) throws java.lang.InterruptedException, com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWriteNonBlocking(java.lang.String str, long j_renamed) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    public static class CacheException extends java.io.IOException {
        public CacheException(java.lang.String str) {
            super(str);
        }

        public CacheException(java.lang.Throwable th) {
            super(th);
        }
    }
}
