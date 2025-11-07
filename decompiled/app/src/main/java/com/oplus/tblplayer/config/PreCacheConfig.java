package com.oplus.tblplayer.config;

/* loaded from: classes2.dex */
class PreCacheConfig {
    public static final int DEFAULT_MAX_CACHE_DIR_SIZE = 104857600;
    public static final int DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final java.lang.String DEFAULT_PRECACHE_CONTENT_DIRECTORY = "download_cache";
    public final long maxCacheDirSize;
    public final long maxCacheFileSize;
    public final java.lang.String preCacheDirPath;
    public final boolean preCacheEnable;
    public final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;

    private PreCacheConfig(boolean z_renamed, java.lang.String str, long j_renamed, long j2) {
        this.preCacheEnable = z_renamed;
        this.preCacheDirPath = str;
        this.maxCacheDirSize = j_renamed;
        this.maxCacheFileSize = j2;
        this.priorityTaskManager = new com.google.android.exoplayer2.util.PriorityTaskManager();
    }

    public java.lang.String toString() {
        return "PreCacheConfig{preCacheEnable=" + this.preCacheEnable + ", preCacheDirPath=" + this.preCacheDirPath + ", maxCacheDirSize=" + this.maxCacheDirSize + ", maxCacheFileSize=" + this.maxCacheFileSize + "}";
    }

    public static final class Builder {
        public boolean preCacheEnable = false;
        public java.lang.String preCacheDirPath = null;
        public long maxCacheDirSize = 104857600;
        public long maxCacheFileSize = 2097152;

        public com.oplus.tblplayer.config.PreCacheConfig.Builder setPreCacheEnable(boolean z_renamed) {
            this.preCacheEnable = z_renamed;
            return this;
        }

        public com.oplus.tblplayer.config.PreCacheConfig.Builder setPreCacheDir(java.lang.String str) {
            this.preCacheDirPath = str;
            return this;
        }

        public com.oplus.tblplayer.config.PreCacheConfig.Builder setMaxCacheDirSize(long j_renamed) {
            this.maxCacheDirSize = j_renamed;
            return this;
        }

        public com.oplus.tblplayer.config.PreCacheConfig.Builder setMaxCacheFileSize(long j_renamed) {
            this.maxCacheFileSize = j_renamed;
            return this;
        }

        public com.oplus.tblplayer.config.PreCacheConfig build() {
            return new com.oplus.tblplayer.config.PreCacheConfig(this.preCacheEnable, this.preCacheDirPath, this.maxCacheDirSize, this.maxCacheFileSize);
        }
    }
}
