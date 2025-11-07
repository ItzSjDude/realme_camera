package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class CacheDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    private static final int CACHE_NOT_IGNORED = -1;
    public static final long DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final long MIN_READ_BEFORE_CHECKING_CACHE = 102400;
    private android.net.Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private final com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory;
    private final com.google.android.exoplayer2.upstream.DataSource cacheReadDataSource;
    private final com.google.android.exoplayer2.upstream.DataSource cacheWriteDataSource;
    private long checkCachePosition;
    private com.google.android.exoplayer2.upstream.DataSource currentDataSource;
    private boolean currentDataSpecLengthUnset;
    private com.google.android.exoplayer2.upstream.cache.CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;
    private final com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener;
    private int flags;
    private int httpMethod;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private java.lang.String key;
    private long readPosition;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final com.google.android.exoplayer2.upstream.DataSource upstreamDataSource;
    private android.net.Uri uri;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i_renamed);

        void onCachedBytesRead(long j_renamed, long j2);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this(cache, dataSource, 0, 2097152L);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource dataSource, int i_renamed) {
        this(cache, dataSource, i_renamed, 2097152L);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource dataSource, int i_renamed, long j_renamed) {
        this(cache, dataSource, new com.google.android.exoplayer2.upstream.FileDataSource(), new com.google.android.exoplayer2.upstream.cache.CacheDataSink(cache, j_renamed), i_renamed, null);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSource dataSource2, com.google.android.exoplayer2.upstream.DataSink dataSink, int i_renamed, com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener) {
        this(cache, dataSource, dataSource2, dataSink, i_renamed, eventListener, null);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSource dataSource2, com.google.android.exoplayer2.upstream.DataSink dataSink, int i_renamed, com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener, com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory) {
        this.cache = cache;
        this.cacheReadDataSource = dataSource2;
        this.cacheKeyFactory = cacheKeyFactory == null ? com.google.android.exoplayer2.upstream.cache.CacheUtil.DEFAULT_CACHE_KEY_FACTORY : cacheKeyFactory;
        this.blockOnCache = (i_renamed & 1) != 0;
        this.ignoreCacheOnError = (i_renamed & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i_renamed & 4) != 0;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new com.google.android.exoplayer2.upstream.TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.cacheReadDataSource.addTransferListener(transferListener);
        this.upstreamDataSource.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        try {
            this.key = this.cacheKeyFactory.buildCacheKey(dataSpec);
            this.uri = dataSpec.uri;
            this.actualUri = getRedirectedUriOrDefault(this.cache, this.key, this.uri);
            this.httpMethod = dataSpec.httpMethod;
            this.flags = dataSpec.flags;
            this.readPosition = dataSpec.position;
            int iShouldIgnoreCacheForRequest = shouldIgnoreCacheForRequest(dataSpec);
            this.currentRequestIgnoresCache = iShouldIgnoreCacheForRequest != -1;
            if (this.currentRequestIgnoresCache) {
                notifyCacheIgnored(iShouldIgnoreCacheForRequest);
            }
            if (dataSpec.length != -1 || this.currentRequestIgnoresCache) {
                this.bytesRemaining = dataSpec.length;
            } else {
                this.bytesRemaining = this.cache.getContentLength(this.key);
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= dataSpec.position;
                    if (this.bytesRemaining <= 0) {
                        throw new com.google.android.exoplayer2.upstream.DataSourceException(0);
                    }
                }
            }
            openNextSource(false);
            return this.bytesRemaining;
        } catch (java.io.IOException e_renamed) {
            handleBeforeThrow(e_renamed);
            throw e_renamed;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            if (this.readPosition >= this.checkCachePosition) {
                openNextSource(true);
            }
            int i3 = this.currentDataSource.read(bArr, i_renamed, i2);
            if (i3 != -1) {
                if (isReadingFromCache()) {
                    this.totalCachedBytesRead += i3;
                }
                long j_renamed = i3;
                this.readPosition += j_renamed;
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= j_renamed;
                }
            } else if (this.currentDataSpecLengthUnset) {
                setNoBytesRemainingAndMaybeStoreLength();
            } else {
                if (this.bytesRemaining <= 0) {
                    if (this.bytesRemaining == -1) {
                    }
                }
                closeCurrentSource();
                openNextSource(false);
                return read(bArr, i_renamed, i2);
            }
            return i3;
        } catch (java.io.IOException e_renamed) {
            if (this.currentDataSpecLengthUnset && isCausedByPositionOutOfRange(e_renamed)) {
                setNoBytesRemainingAndMaybeStoreLength();
                return -1;
            }
            handleBeforeThrow(e_renamed);
            throw e_renamed;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.actualUri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        if (isReadingFromUpstream()) {
            return this.upstreamDataSource.getResponseHeaders();
        }
        return java.util.Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        this.uri = null;
        this.actualUri = null;
        this.httpMethod = 1;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (java.io.IOException e_renamed) {
            handleBeforeThrow(e_renamed);
            throw e_renamed;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:40:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:65:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:78:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openNextSource(boolean r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheDataSource.openNextSource(boolean):void");
    }

    private void setNoBytesRemainingAndMaybeStoreLength() throws java.io.IOException {
        this.bytesRemaining = 0L;
        if (isWritingToCache()) {
            this.cache.setContentLength(this.key, this.readPosition);
        }
    }

    private static android.net.Uri getRedirectedUriOrDefault(com.google.android.exoplayer2.upstream.cache.Cache cache, java.lang.String str, android.net.Uri uri) {
        android.net.Uri redirectedUri = com.google.android.exoplayer2.upstream.cache.ContentMetadataInternal.getRedirectedUri(cache.getContentMetadata(str));
        return redirectedUri == null ? uri : redirectedUri;
    }

    private static boolean isCausedByPositionOutOfRange(java.io.IOException iOException) {
        for (java.io.IOException cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof com.google.android.exoplayer2.upstream.DataSourceException) && ((com.google.android.exoplayer2.upstream.DataSourceException) cause).reason == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isReadingFromUpstream() {
        return !isReadingFromCache();
    }

    private boolean isBypassingCache() {
        return this.currentDataSource == this.upstreamDataSource;
    }

    private boolean isReadingFromCache() {
        return this.currentDataSource == this.cacheReadDataSource;
    }

    private boolean isWritingToCache() {
        return this.currentDataSource == this.cacheWriteDataSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void closeCurrentSource() throws java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.currentDataSource = null;
            this.currentDataSpecLengthUnset = false;
            com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan = this.currentHoleSpan;
            if (cacheSpan != null) {
                this.cache.releaseHoleSpan(cacheSpan);
                this.currentHoleSpan = null;
            }
        }
    }

    private void handleBeforeThrow(java.io.IOException iOException) {
        if (isReadingFromCache() || (iOException instanceof com.google.android.exoplayer2.upstream.cache.Cache.CacheException)) {
            this.seenCacheError = true;
        }
    }

    private int shouldIgnoreCacheForRequest(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        if (this.ignoreCacheOnError && this.seenCacheError) {
            return 0;
        }
        return (this.ignoreCacheForUnsetLengthRequests && dataSpec.length == -1) ? 1 : -1;
    }

    private void notifyCacheIgnored(int i_renamed) {
        com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onCacheIgnored(i_renamed);
        }
    }

    private void notifyBytesRead() {
        com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener = this.eventListener;
        if (eventListener == null || this.totalCachedBytesRead <= 0) {
            return;
        }
        eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
        this.totalCachedBytesRead = 0L;
    }
}
