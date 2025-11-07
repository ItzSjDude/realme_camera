package com.oplus.tblplayer.cache.impl;

/* loaded from: classes2.dex */
public class DefaultCacheManagerImpl implements com.google.android.exoplayer2.upstream.TransferListener, com.oplus.tblplayer.cache.ICacheManager {
    private static final int CORE_SIZE = 2;
    private static final long KEEP_ALIVE_TIME = 900;
    private static final int MAX_BLOCKING_SIZE = 6;
    private static final int MAX_SIZE = 3;
    private static final java.lang.String TAG = "DefaultCacheManagerImpl";
    private static final java.lang.String THREAD_NAME = "preload";
    private android.content.Context mAppContext;
    private com.oplus.tblplayer.cache.ICacheListener mListener;
    private com.oplus.tblplayer.cache.ICacheListener mInnerListener = new com.oplus.tblplayer.cache.ICacheListener() { // from class: com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.1
        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheStart(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
            if (com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.mListener != null) {
                com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.mListener.onCacheStart(mediaUrl);
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheFinish(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, long j3, long j4) {
            if (com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.mListener != null) {
                com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.mListener.onCacheFinish(mediaUrl, j_renamed, j2, j3, j4);
            }
            com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.removeCacheTask(mediaUrl);
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheError(com.oplus.tblplayer.misc.MediaUrl mediaUrl, int i_renamed, java.lang.String str) {
            if (com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.mListener != null) {
                com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.mListener.onCacheError(mediaUrl, i_renamed, str);
            }
            com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.this.removeCacheTask(mediaUrl);
        }
    };
    private java.util.concurrent.ThreadPoolExecutor mExecutor = new java.util.concurrent.ThreadPoolExecutor(2, 3, KEEP_ALIVE_TIME, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(6), new com.oplus.tblplayer.utils.executor.DefaultThreadFactory(THREAD_NAME), new com.oplus.tblplayer.utils.executor.DefaultDiscardPolicy());
    private com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = com.oplus.tblplayer.config.Globals.getPriorityTaskManager();
    private java.util.List<com.oplus.tblplayer.cache.ICacheTask> mTasks = new java.util.concurrent.CopyOnWriteArrayList();
    private com.google.android.exoplayer2.upstream.cache.Cache mCache = com.oplus.tblplayer.config.Globals.getGlobalPreCache();

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed, int i_renamed) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferEnd(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferStart(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed) {
    }

    public DefaultCacheManagerImpl(android.content.Context context) {
        this.mAppContext = context;
    }

    public com.google.android.exoplayer2.upstream.DataSource.Factory buildDataSourceFactory(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        com.google.android.exoplayer2.upstream.HttpDataSource.Factory factoryBuildHttpDataSourceFactory;
        if (com.oplus.tblplayer.config.Globals.getOkhttpEnable()) {
            factoryBuildHttpDataSourceFactory = com.oplus.tblplayer.managers.TBLSourceManager.buildOkHttpDataSourceFactory(com.oplus.tblplayer.config.Globals.getUserAgent(), com.oplus.tblplayer.config.Globals.getOkhttpCallFactory(), com.oplus.tblplayer.config.Globals.getOkhttpCacheControl());
        } else {
            factoryBuildHttpDataSourceFactory = com.oplus.tblplayer.managers.TBLSourceManager.buildHttpDataSourceFactory(com.oplus.tblplayer.config.Globals.getUserAgent());
        }
        if (!mediaUrl.isHttpRequestHeadersEmpty()) {
            factoryBuildHttpDataSourceFactory.getDefaultRequestProperties().set(mediaUrl.getHeaders());
        }
        return new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory(this.mAppContext, factoryBuildHttpDataSourceFactory);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2) {
        startCache(mediaUrl, j_renamed, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, int i_renamed) {
        if (mediaUrl == null || android.text.TextUtils.isEmpty(mediaUrl.toString())) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "startCache ignore due to empty url");
            return;
        }
        if (!com.oplus.tblplayer.managers.TBLSourceManager.shouldRequirePreCache(mediaUrl)) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "startCache ignore due to local file");
            return;
        }
        com.oplus.tblplayer.cache.ICacheTask cacheTask = getCacheTask(mediaUrl);
        if (cacheTask != null) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "startCache ignore due to task already exists. task: " + cacheTask.toString() + ", url key: " + getKey(mediaUrl));
            return;
        }
        com.oplus.tblplayer.cache.impl.CacheTaskImpl cacheTaskImplWrapTask = wrapTask(mediaUrl, j_renamed, j2, i_renamed);
        addTask(cacheTaskImplWrapTask);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "startCache schedule task: " + cacheTaskImplWrapTask.toString() + ", url key: " + getKey(mediaUrl));
        this.mExecutor.execute(cacheTaskImplWrapTask);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "[CACHE] stopAllCache, ThreadPoolExecutor pool size: " + this.mExecutor.getPoolSize() + ", and queue size: " + this.mExecutor.getQueue().size());
        for (com.oplus.tblplayer.cache.ICacheTask iCacheTask : this.mTasks) {
            iCacheTask.cancel();
            removeTask(iCacheTask);
            this.mExecutor.remove((java.lang.Runnable) iCacheTask);
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        this.mListener = iCacheListener;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        this.mListener = null;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        if (mediaUrl == null || android.text.TextUtils.isEmpty(mediaUrl.toString())) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "stopCache ignore due to empty url");
            return;
        }
        com.oplus.tblplayer.cache.ICacheTask cacheTask = getCacheTask(mediaUrl);
        if (cacheTask == null || cacheTask.isFinished()) {
            return;
        }
        cacheTask.cancel();
        removeTask(cacheTask);
    }

    private java.lang.String getUserAgent() {
        return !android.text.TextUtils.isEmpty(com.oplus.tblplayer.config.Globals.getUserAgent()) ? com.oplus.tblplayer.config.Globals.getUserAgent() : "";
    }

    private com.oplus.tblplayer.cache.ICacheTask getCacheTask(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        java.lang.String key = getKey(mediaUrl);
        for (com.oplus.tblplayer.cache.ICacheTask iCacheTask : this.mTasks) {
            if (key.equals(iCacheTask.getKey())) {
                return iCacheTask;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCacheTask(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        java.lang.String key = getKey(mediaUrl);
        for (com.oplus.tblplayer.cache.ICacheTask iCacheTask : this.mTasks) {
            if (key.equals(iCacheTask.getKey())) {
                removeTask(iCacheTask);
                return;
            }
        }
    }

    private boolean removeTask(com.oplus.tblplayer.cache.ICacheTask iCacheTask) {
        return this.mTasks.remove(iCacheTask);
    }

    private boolean addTask(com.oplus.tblplayer.cache.ICacheTask iCacheTask) {
        return this.mTasks.add(iCacheTask);
    }

    private com.oplus.tblplayer.cache.impl.CacheTaskImpl wrapTask(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, int i_renamed) {
        return new com.oplus.tblplayer.cache.impl.CacheTaskImpl(this.mInnerListener, this.mCache, buildDataSourceFactory(mediaUrl), this.priorityTaskManager, mediaUrl, j_renamed, j2, i_renamed);
    }

    public java.lang.String getKey(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        java.lang.String customCacheKey = mediaUrl.getCustomCacheKey();
        return customCacheKey == null ? mediaUrl.toString() : customCacheKey;
    }
}
