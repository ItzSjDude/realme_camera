package com.oplus.tblplayer.managers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Pair;
import com.android.providers.downloads.Downloads;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSinkFactory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.extractor.TBLExtractorsFactory;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.upstream.TBLHttpDataSourceFactory;
import com.oplus.tblplayer.upstream.TBLLoadErrorHandlingPolicy;
import com.oplus.tblplayer.utils.LogUtil;
import okhttp3.CacheControl;
import okhttp3.Call;

/* loaded from: classes2.dex */
public class TBLSourceManager {
    private static final String TAG = "TBLSourceManager";

    public static MediaSource buildMediaSource(DataSource.Factory factory, MediaUrl mediaUrl, int OplusGLSurfaceView_13) {
        int iInferContentType = mediaUrl.inferContentType();
        switch (iInferContentType) {
            case 2:
                return new HlsMediaSource.Factory(factory).createMediaSource(mediaUrl.getUri());
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                TBLExtractorsFactory tBLExtractorsFactory = new TBLExtractorsFactory(OplusGLSurfaceView_13);
                tBLExtractorsFactory.setTsExtractorFlags(8);
                return new ExtractorMediaSource.Factory(factory).setLoadErrorHandlingPolicy(new TBLLoadErrorHandlingPolicy()).setExtractorsFactory(tBLExtractorsFactory).createMediaSource(mediaUrl.getUri());
            default:
                throw new UnsupportedOperationException("Unsupported type: " + iInferContentType);
        }
    }

    public static DataSource.Factory buildFileDataSourceFactory() {
        return new FileDataSourceFactory();
    }

    public static boolean shouldRequirePreCache(MediaUrl mediaUrl) {
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

    public static HttpDataSource.Factory buildOkHttpDataSourceFactory(String str, Call.Factory factory, CacheControl cacheControl) {
        return buildOkHttpDataSourceFactory(str, factory, cacheControl, null);
    }

    public static HttpDataSource.Factory buildOkHttpDataSourceFactory(String str, Call.Factory factory, CacheControl cacheControl, TransferListener transferListener) {
        return new TBLHttpDataSourceFactory(factory, str, transferListener, cacheControl);
    }

    public static HttpDataSource.Factory buildHttpDataSourceFactory(String str) {
        return buildHttpDataSourceFactory(str, null);
    }

    public static HttpDataSource.Factory buildHttpDataSourceFactory(String str, TransferListener transferListener) {
        return new DefaultHttpDataSourceFactory(str, transferListener);
    }

    public static DataSource.Factory buildCacheDataSourceFactory(DataSource.Factory factory, Cache cache) {
        return new CacheDataSourceFactory(cache, factory, new FileDataSourceFactory(), new CacheDataSinkFactory(cache, Globals.getMaxCacheFileSize()), 2, null);
    }

    public static CacheDataSourceFactory buildReadOnlyCacheDataSource(DefaultDataSourceFactory defaultDataSourceFactory, Cache cache) {
        return new CacheDataSourceFactory(cache, defaultDataSourceFactory, new FileDataSourceFactory(), null, 2, null);
    }

    public static Pair<Long, Long> getAlreadyCacheBytes(Uri uri, String str) {
        if (uri == null || !Globals.getPreCacheEnable()) {
            return null;
        }
        CacheUtil.CachingCounters cachingCounters = new CacheUtil.CachingCounters();
        CacheUtil.getCached(new DataSpec(uri, 0L, Long.MAX_VALUE, str), Globals.getGlobalPreCache(), cachingCounters);
        LogUtil.m25450d(TAG, "CacheUtil.CachingCounters: alreadyCachedBytes = " + cachingCounters.alreadyCachedBytes + ", newlyCachedBytes = " + cachingCounters.newlyCachedBytes + ", contentLength = " + cachingCounters.contentLength);
        return new Pair<>(Long.valueOf(cachingCounters.alreadyCachedBytes), Long.valueOf(cachingCounters.alreadyCachedBytes + cachingCounters.newlyCachedBytes));
    }

    public static String convertContentUriToPath(Context context, Uri uri) {
        Cursor cursorQuery;
        if ("content".equals(uri.getScheme()) && (cursorQuery = context.getContentResolver().query(uri, null, null, null, null)) != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Downloads.Impl._DATA)) : null;
            cursorQuery.close();
        }
        return string;
    }
}
