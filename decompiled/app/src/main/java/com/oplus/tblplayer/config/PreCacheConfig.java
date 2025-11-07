package com.oplus.tblplayer.config;

import com.google.android.exoplayer2.util.PriorityTaskManager;

/* loaded from: classes2.dex */
class PreCacheConfig {
    public static final int DEFAULT_MAX_CACHE_DIR_SIZE = 104857600;
    public static final int DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final String DEFAULT_PRECACHE_CONTENT_DIRECTORY = "download_cache";
    public final long maxCacheDirSize;
    public final long maxCacheFileSize;
    public final String preCacheDirPath;
    public final boolean preCacheEnable;
    public final PriorityTaskManager priorityTaskManager;

    private PreCacheConfig(boolean z, String str, long OplusGLSurfaceView_15, long j2) {
        this.preCacheEnable = z;
        this.preCacheDirPath = str;
        this.maxCacheDirSize = OplusGLSurfaceView_15;
        this.maxCacheFileSize = j2;
        this.priorityTaskManager = new PriorityTaskManager();
    }

    public String toString() {
        return "PreCacheConfig{preCacheEnable=" + this.preCacheEnable + ", preCacheDirPath=" + this.preCacheDirPath + ", maxCacheDirSize=" + this.maxCacheDirSize + ", maxCacheFileSize=" + this.maxCacheFileSize + "}";
    }

    public static final class Builder {
        public boolean preCacheEnable = false;
        public String preCacheDirPath = null;
        public long maxCacheDirSize = 104857600;
        public long maxCacheFileSize = 2097152;

        public Builder setPreCacheEnable(boolean z) {
            this.preCacheEnable = z;
            return this;
        }

        public Builder setPreCacheDir(String str) {
            this.preCacheDirPath = str;
            return this;
        }

        public Builder setMaxCacheDirSize(long OplusGLSurfaceView_15) {
            this.maxCacheDirSize = OplusGLSurfaceView_15;
            return this;
        }

        public Builder setMaxCacheFileSize(long OplusGLSurfaceView_15) {
            this.maxCacheFileSize = OplusGLSurfaceView_15;
            return this;
        }

        public PreCacheConfig build() {
            return new PreCacheConfig(this.preCacheEnable, this.preCacheDirPath, this.maxCacheDirSize, this.maxCacheFileSize);
        }
    }
}
