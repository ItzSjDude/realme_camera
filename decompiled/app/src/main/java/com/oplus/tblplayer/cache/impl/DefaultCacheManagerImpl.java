package com.oplus.tblplayer.cache.impl;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheManager;
import com.oplus.tblplayer.cache.ICacheTask;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.managers.TBLSourceManager;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.executor.DefaultDiscardPolicy;
import com.oplus.tblplayer.utils.executor.DefaultThreadFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DefaultCacheManagerImpl implements TransferListener, ICacheManager {
    private static final int CORE_SIZE = 2;
    private static final long KEEP_ALIVE_TIME = 900;
    private static final int MAX_BLOCKING_SIZE = 6;
    private static final int MAX_SIZE = 3;
    private static final String TAG = "DefaultCacheManagerImpl";
    private static final String THREAD_NAME = "preload";
    private Context mAppContext;
    private ICacheListener mListener;
    private ICacheListener mInnerListener = new ICacheListener() { // from class: com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.1
        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheStart(MediaUrl mediaUrl) {
            if (DefaultCacheManagerImpl.this.mListener != null) {
                DefaultCacheManagerImpl.this.mListener.onCacheStart(mediaUrl);
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheFinish(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, long j3, long j4) {
            if (DefaultCacheManagerImpl.this.mListener != null) {
                DefaultCacheManagerImpl.this.mListener.onCacheFinish(mediaUrl, OplusGLSurfaceView_15, j2, j3, j4);
            }
            DefaultCacheManagerImpl.this.removeCacheTask(mediaUrl);
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheError(MediaUrl mediaUrl, int OplusGLSurfaceView_13, String str) {
            if (DefaultCacheManagerImpl.this.mListener != null) {
                DefaultCacheManagerImpl.this.mListener.onCacheError(mediaUrl, OplusGLSurfaceView_13, str);
            }
            DefaultCacheManagerImpl.this.removeCacheTask(mediaUrl);
        }
    };
    private ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(2, 3, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue(6), new DefaultThreadFactory(THREAD_NAME), new DefaultDiscardPolicy());
    private PriorityTaskManager priorityTaskManager = Globals.getPriorityTaskManager();
    private List<ICacheTask> mTasks = new CopyOnWriteArrayList();
    private Cache mCache = Globals.getGlobalPreCache();

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int OplusGLSurfaceView_13) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    public DefaultCacheManagerImpl(Context context) {
        this.mAppContext = context;
    }

    public DataSource.Factory buildDataSourceFactory(MediaUrl mediaUrl) {
        HttpDataSource.Factory factoryBuildHttpDataSourceFactory;
        if (Globals.getOkhttpEnable()) {
            factoryBuildHttpDataSourceFactory = TBLSourceManager.buildOkHttpDataSourceFactory(Globals.getUserAgent(), Globals.getOkhttpCallFactory(), Globals.getOkhttpCacheControl());
        } else {
            factoryBuildHttpDataSourceFactory = TBLSourceManager.buildHttpDataSourceFactory(Globals.getUserAgent());
        }
        if (!mediaUrl.isHttpRequestHeadersEmpty()) {
            factoryBuildHttpDataSourceFactory.getDefaultRequestProperties().set(mediaUrl.getHeaders());
        }
        return new DefaultDataSourceFactory(this.mAppContext, factoryBuildHttpDataSourceFactory);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2) {
        startCache(mediaUrl, OplusGLSurfaceView_15, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        if (mediaUrl == null || TextUtils.isEmpty(mediaUrl.toString())) {
            LogUtil.m25450d(TAG, "startCache ignore due to empty url");
            return;
        }
        if (!TBLSourceManager.shouldRequirePreCache(mediaUrl)) {
            LogUtil.m25450d(TAG, "startCache ignore due to local file");
            return;
        }
        ICacheTask cacheTask = getCacheTask(mediaUrl);
        if (cacheTask != null) {
            LogUtil.m25450d(TAG, "startCache ignore due to task already exists. task: " + cacheTask.toString() + ", url key: " + getKey(mediaUrl));
            return;
        }
        CacheTaskImpl cacheTaskImplWrapTask = wrapTask(mediaUrl, OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
        addTask(cacheTaskImplWrapTask);
        LogUtil.m25450d(TAG, "startCache schedule task: " + cacheTaskImplWrapTask.toString() + ", url key: " + getKey(mediaUrl));
        this.mExecutor.execute(cacheTaskImplWrapTask);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        LogUtil.m25450d(TAG, "[CACHE] stopAllCache, ThreadPoolExecutor pool size: " + this.mExecutor.getPoolSize() + ", and queue size: " + this.mExecutor.getQueue().size());
        for (ICacheTask iCacheTask : this.mTasks) {
            iCacheTask.cancel();
            removeTask(iCacheTask);
            this.mExecutor.remove((Runnable) iCacheTask);
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        this.mListener = iCacheListener;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        this.mListener = null;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        if (mediaUrl == null || TextUtils.isEmpty(mediaUrl.toString())) {
            LogUtil.m25450d(TAG, "stopCache ignore due to empty url");
            return;
        }
        ICacheTask cacheTask = getCacheTask(mediaUrl);
        if (cacheTask == null || cacheTask.isFinished()) {
            return;
        }
        cacheTask.cancel();
        removeTask(cacheTask);
    }

    private String getUserAgent() {
        return !TextUtils.isEmpty(Globals.getUserAgent()) ? Globals.getUserAgent() : "";
    }

    private ICacheTask getCacheTask(MediaUrl mediaUrl) {
        String key = getKey(mediaUrl);
        for (ICacheTask iCacheTask : this.mTasks) {
            if (key.equals(iCacheTask.getKey())) {
                return iCacheTask;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCacheTask(MediaUrl mediaUrl) {
        String key = getKey(mediaUrl);
        for (ICacheTask iCacheTask : this.mTasks) {
            if (key.equals(iCacheTask.getKey())) {
                removeTask(iCacheTask);
                return;
            }
        }
    }

    private boolean removeTask(ICacheTask iCacheTask) {
        return this.mTasks.remove(iCacheTask);
    }

    private boolean addTask(ICacheTask iCacheTask) {
        return this.mTasks.add(iCacheTask);
    }

    private CacheTaskImpl wrapTask(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        return new CacheTaskImpl(this.mInnerListener, this.mCache, buildDataSourceFactory(mediaUrl), this.priorityTaskManager, mediaUrl, OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
    }

    public String getKey(MediaUrl mediaUrl) {
        String customCacheKey = mediaUrl.getCustomCacheKey();
        return customCacheKey == null ? mediaUrl.toString() : customCacheKey;
    }
}
