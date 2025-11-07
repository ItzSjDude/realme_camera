package com.oplus.tblplayer.config;

import android.content.Context;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.oplus.tblplayer.config.GlobalsConfig;
import com.oplus.tblplayer.utils.FileUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.CacheControl;
import okhttp3.Call;

/* loaded from: classes2.dex */
public class Globals {
    public static boolean DEBUG = false;
    public static final String PREFIX_TAG = "TBLPlayer-";
    private static GlobalsConfig gGlobalsConfig;
    private static AtomicBoolean initState = new AtomicBoolean(false);
    private static Cache sPreCache;

    public static synchronized void maybeInitialize(Context context, GlobalsConfig globalsConfig) {
        if (initState.get()) {
            return;
        }
        if (gGlobalsConfig == null) {
            if (globalsConfig == null) {
                globalsConfig = new GlobalsConfig.Builder(context).build();
            }
            gGlobalsConfig = globalsConfig;
            DEBUG = gGlobalsConfig.debug;
            initState.set(true);
        }
    }

    public static synchronized boolean isInitialized() {
        return initState.get();
    }

    public static GlobalsConfig getGlobalsConfig() {
        Assertions.checkState(isInitialized());
        return gGlobalsConfig;
    }

    public static Context getApplicationContext() {
        return getGlobalsConfig().appContext;
    }

    public static String getUserAgent() {
        return getGlobalsConfig().httpConfig.userAgent;
    }

    public static long getMaxCacheFileSize() {
        return getGlobalsConfig().preCacheConfig.maxCacheFileSize;
    }

    public static long getMaxCacheDirSize() {
        return getGlobalsConfig().preCacheConfig.maxCacheDirSize;
    }

    public static String getPreCacheDirPath() {
        return getGlobalsConfig().preCacheConfig.preCacheDirPath;
    }

    public static boolean getPreCacheEnable() {
        return getGlobalsConfig().preCacheConfig.preCacheEnable;
    }

    public static boolean getOkhttpEnable() {
        return getGlobalsConfig().httpConfig.okhttpEnable;
    }

    public static Call.Factory getOkhttpCallFactory() {
        return getGlobalsConfig().httpConfig.okhttpCallFactory;
    }

    public static boolean getPreferRedirectAddress() {
        return getGlobalsConfig().httpConfig.preferRedirectAddress;
    }

    public static CacheControl getOkhttpCacheControl() {
        return getGlobalsConfig().httpConfig.okhttpCacheControl;
    }

    public static PriorityTaskManager getPriorityTaskManager() {
        return getGlobalsConfig().preCacheConfig.priorityTaskManager;
    }

    public static Cache getGlobalPreCache() {
        if (getPreCacheEnable() && sPreCache == null) {
            synchronized (Globals.class) {
                if (sPreCache == null) {
                    sPreCache = createPreCache(getApplicationContext(), getPreCacheDirPath(), getMaxCacheDirSize());
                }
            }
        }
        return sPreCache;
    }

    private static Cache createPreCache(Context context, String str, long OplusGLSurfaceView_15) {
        File directoryByPath = FileUtil.getDirectoryByPath(str);
        if (directoryByPath == null) {
            directoryByPath = FileUtil.getDirectoryByName(context, PreCacheConfig.DEFAULT_PRECACHE_CONTENT_DIRECTORY);
        }
        if (directoryByPath == null) {
            return null;
        }
        if (SimpleCache.isCacheFolderLocked(directoryByPath)) {
            SimpleCache.disableCacheFolderLocking();
        }
        return new SimpleCache(directoryByPath, new LeastRecentlyUsedCacheEvictor(OplusGLSurfaceView_15));
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }
}
