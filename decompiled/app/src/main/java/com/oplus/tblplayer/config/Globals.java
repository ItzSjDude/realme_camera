package com.oplus.tblplayer.config;

/* loaded from: classes2.dex */
public class Globals {
    public static boolean DEBUG = false;
    public static final java.lang.String PREFIX_TAG = "TBLPlayer-";
    private static com.oplus.tblplayer.config.GlobalsConfig gGlobalsConfig;
    private static java.util.concurrent.atomic.AtomicBoolean initState = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static com.google.android.exoplayer2.upstream.cache.Cache sPreCache;

    public static synchronized void maybeInitialize(android.content.Context context, com.oplus.tblplayer.config.GlobalsConfig globalsConfig) {
        if (initState.get()) {
            return;
        }
        if (gGlobalsConfig == null) {
            if (globalsConfig == null) {
                globalsConfig = new com.oplus.tblplayer.config.GlobalsConfig.Builder(context).build();
            }
            gGlobalsConfig = globalsConfig;
            DEBUG = gGlobalsConfig.debug;
            initState.set(true);
        }
    }

    public static synchronized boolean isInitialized() {
        return initState.get();
    }

    public static com.oplus.tblplayer.config.GlobalsConfig getGlobalsConfig() {
        com.google.android.exoplayer2.util.Assertions.checkState(isInitialized());
        return gGlobalsConfig;
    }

    public static android.content.Context getApplicationContext() {
        return getGlobalsConfig().appContext;
    }

    public static java.lang.String getUserAgent() {
        return getGlobalsConfig().httpConfig.userAgent;
    }

    public static long getMaxCacheFileSize() {
        return getGlobalsConfig().preCacheConfig.maxCacheFileSize;
    }

    public static long getMaxCacheDirSize() {
        return getGlobalsConfig().preCacheConfig.maxCacheDirSize;
    }

    public static java.lang.String getPreCacheDirPath() {
        return getGlobalsConfig().preCacheConfig.preCacheDirPath;
    }

    public static boolean getPreCacheEnable() {
        return getGlobalsConfig().preCacheConfig.preCacheEnable;
    }

    public static boolean getOkhttpEnable() {
        return getGlobalsConfig().httpConfig.okhttpEnable;
    }

    public static okhttp3.Call.Factory getOkhttpCallFactory() {
        return getGlobalsConfig().httpConfig.okhttpCallFactory;
    }

    public static boolean getPreferRedirectAddress() {
        return getGlobalsConfig().httpConfig.preferRedirectAddress;
    }

    public static okhttp3.CacheControl getOkhttpCacheControl() {
        return getGlobalsConfig().httpConfig.okhttpCacheControl;
    }

    public static com.google.android.exoplayer2.util.PriorityTaskManager getPriorityTaskManager() {
        return getGlobalsConfig().preCacheConfig.priorityTaskManager;
    }

    public static com.google.android.exoplayer2.upstream.cache.Cache getGlobalPreCache() {
        if (getPreCacheEnable() && sPreCache == null) {
            synchronized (com.oplus.tblplayer.config.Globals.class) {
                if (sPreCache == null) {
                    sPreCache = createPreCache(getApplicationContext(), getPreCacheDirPath(), getMaxCacheDirSize());
                }
            }
        }
        return sPreCache;
    }

    private static com.google.android.exoplayer2.upstream.cache.Cache createPreCache(android.content.Context context, java.lang.String str, long j_renamed) {
        java.io.File directoryByPath = com.oplus.tblplayer.utils.FileUtil.getDirectoryByPath(str);
        if (directoryByPath == null) {
            directoryByPath = com.oplus.tblplayer.utils.FileUtil.getDirectoryByName(context, com.oplus.tblplayer.config.PreCacheConfig.DEFAULT_PRECACHE_CONTENT_DIRECTORY);
        }
        if (directoryByPath == null) {
            return null;
        }
        if (com.google.android.exoplayer2.upstream.cache.SimpleCache.isCacheFolderLocked(directoryByPath)) {
            com.google.android.exoplayer2.upstream.cache.SimpleCache.disableCacheFolderLocking();
        }
        return new com.google.android.exoplayer2.upstream.cache.SimpleCache(directoryByPath, new com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor(j_renamed));
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
    }
}
