package com.oplus.tblplayer.managers;

/* loaded from: classes2.dex */
public class TBLSourceManager {
    private static final java.lang.String TAG = "TBLSourceManager";

    public static com.google.android.exoplayer2.source.MediaSource buildMediaSource(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.oplus.tblplayer.misc.MediaUrl mediaUrl, int i_renamed) {
        int iInferContentType = mediaUrl.inferContentType();
        switch (iInferContentType) {
            case 2:
                return new com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory(factory).createMediaSource(mediaUrl.getUri());
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                com.oplus.tblplayer.extractor.TBLExtractorsFactory tBLExtractorsFactory = new com.oplus.tblplayer.extractor.TBLExtractorsFactory(i_renamed);
                tBLExtractorsFactory.setTsExtractorFlags(8);
                return new com.google.android.exoplayer2.source.ExtractorMediaSource.Factory(factory).setLoadErrorHandlingPolicy(new com.oplus.tblplayer.upstream.TBLLoadErrorHandlingPolicy()).setExtractorsFactory(tBLExtractorsFactory).createMediaSource(mediaUrl.getUri());
            default:
                throw new java.lang.UnsupportedOperationException("Unsupported type: " + iInferContentType);
        }
    }

    public static com.google.android.exoplayer2.upstream.DataSource.Factory buildFileDataSourceFactory() {
        return new com.google.android.exoplayer2.upstream.FileDataSourceFactory();
    }

    public static boolean shouldRequirePreCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        switch (mediaUrl.inferContentType()) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                return true;
        }
    }

    public static com.google.android.exoplayer2.upstream.HttpDataSource.Factory buildOkHttpDataSourceFactory(java.lang.String str, okhttp3.Call.Factory factory, okhttp3.CacheControl cacheControl) {
        return buildOkHttpDataSourceFactory(str, factory, cacheControl, null);
    }

    public static com.google.android.exoplayer2.upstream.HttpDataSource.Factory buildOkHttpDataSourceFactory(java.lang.String str, okhttp3.Call.Factory factory, okhttp3.CacheControl cacheControl, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        return new com.oplus.tblplayer.upstream.TBLHttpDataSourceFactory(factory, str, transferListener, cacheControl);
    }

    public static com.google.android.exoplayer2.upstream.HttpDataSource.Factory buildHttpDataSourceFactory(java.lang.String str) {
        return buildHttpDataSourceFactory(str, null);
    }

    public static com.google.android.exoplayer2.upstream.HttpDataSource.Factory buildHttpDataSourceFactory(java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        return new com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory(str, transferListener);
    }

    public static com.google.android.exoplayer2.upstream.DataSource.Factory buildCacheDataSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.cache.Cache cache) {
        return new com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory(cache, factory, new com.google.android.exoplayer2.upstream.FileDataSourceFactory(), new com.google.android.exoplayer2.upstream.cache.CacheDataSinkFactory(cache, com.oplus.tblplayer.config.Globals.getMaxCacheFileSize()), 2, null);
    }

    public static com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory buildReadOnlyCacheDataSource(com.google.android.exoplayer2.upstream.DefaultDataSourceFactory defaultDataSourceFactory, com.google.android.exoplayer2.upstream.cache.Cache cache) {
        return new com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory(cache, defaultDataSourceFactory, new com.google.android.exoplayer2.upstream.FileDataSourceFactory(), null, 2, null);
    }

    public static android.util.Pair<java.lang.Long, java.lang.Long> getAlreadyCacheBytes(android.net.Uri uri, java.lang.String str) {
        if (uri == null || !com.oplus.tblplayer.config.Globals.getPreCacheEnable()) {
            return null;
        }
        com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters cachingCounters = new com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters();
        com.google.android.exoplayer2.upstream.cache.CacheUtil.getCached(new com.google.android.exoplayer2.upstream.DataSpec(uri, 0L, Long.MAX_VALUE, str), com.oplus.tblplayer.config.Globals.getGlobalPreCache(), cachingCounters);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "CacheUtil.CachingCounters: alreadyCachedBytes = " + cachingCounters.alreadyCachedBytes + ", newlyCachedBytes = " + cachingCounters.newlyCachedBytes + ", contentLength = " + cachingCounters.contentLength);
        return new android.util.Pair<>(java.lang.Long.valueOf(cachingCounters.alreadyCachedBytes), java.lang.Long.valueOf(cachingCounters.alreadyCachedBytes + cachingCounters.newlyCachedBytes));
    }

    public static java.lang.String convertContentUriToPath(android.content.Context context, android.net.Uri uri) {
        android.database.Cursor cursorQuery;
        if ("content".equals(uri.getScheme()) && (cursorQuery = context.getContentResolver().query(uri, null, null, null, null)) != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(com.android.providers.downloads.Downloads.Impl._DATA)) : null;
            cursorQuery.close();
        }
        return string;
    }
}
