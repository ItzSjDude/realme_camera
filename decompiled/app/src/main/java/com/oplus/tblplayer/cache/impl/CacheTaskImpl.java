package com.oplus.tblplayer.cache.impl;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheTask;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.executor.SafeRunnable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class CacheTaskImpl extends SafeRunnable implements ICacheTask {
    private static final String TAG = "CacheTaskImpl";
    private Cache mCache;
    private DataSource.Factory mDataSourceFactory;
    private long mLength;
    private ICacheListener mListener;
    private int mPriority;
    private PriorityTaskManager mPriorityTaskManager;
    private long mStartPos;
    private MediaUrl mUrl;
    private CacheUtil.CachingCounters mCounters = new CacheUtil.CachingCounters();
    private volatile boolean mFinished = false;
    private AtomicBoolean mCancel = new AtomicBoolean(false);
    private String mIdentify = toString();

    public CacheTaskImpl(ICacheListener iCacheListener, Cache cache, DataSource.Factory factory, PriorityTaskManager priorityTaskManager, MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        this.mListener = iCacheListener;
        this.mCache = cache;
        this.mDataSourceFactory = factory;
        this.mUrl = mediaUrl;
        this.mStartPos = OplusGLSurfaceView_15;
        this.mLength = j2;
        this.mPriorityTaskManager = priorityTaskManager;
        this.mPriority = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.tblplayer.cache.ICacheTask
    public String getKey() {
        String customCacheKey = this.mUrl.getCustomCacheKey();
        return customCacheKey == null ? this.mUrl.toString() : customCacheKey;
    }

    @Override // com.oplus.tblplayer.utils.executor.SafeRunnable
    protected void safeRun() {
        DataSpec dataSpec;
        if (this.mPriority >= 0) {
            LogUtil.m25452e(TAG, "Priority should not greater than PLAYBACK!");
            this.mPriority = -1;
        }
        this.mPriorityTaskManager.add(this.mPriority);
        onCacheStart();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            dataSpec = new DataSpec(this.mUrl.getUri(), this.mStartPos, this.mLength, this.mUrl.getCustomCacheKey());
            CacheUtil.getCached(dataSpec, this.mCache, this.mCounters);
        } catch (Exception COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "Cache error: " + COUIBaseListPopupWindow_8.getMessage());
            onCacheError(COUIBaseListPopupWindow_8.getMessage());
        }
        if (this.mCounters.alreadyCachedBytes > 0) {
            LogUtil.m25454i(TAG, "Cache ignore due to already cached. task: " + this.mIdentify + ", url key: " + getKey() + ", alreadyCachedBytes: " + this.mCounters.alreadyCachedBytes);
            onCacheFinish(this.mCounters.contentLength, this.mCounters.alreadyCachedBytes, 0L, System.currentTimeMillis() - jCurrentTimeMillis);
            return;
        }
        CacheUtil.cache(dataSpec, this.mCache, new CacheDataSource(this.mCache, this.mDataSourceFactory.createDataSource()), new byte[131072], this.mPriorityTaskManager, this.mPriority, this.mCounters, this.mCancel, false);
        this.mFinished = true;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        onCacheFinish(this.mCounters.contentLength, this.mCounters.alreadyCachedBytes, this.mCounters.newlyCachedBytes, jCurrentTimeMillis2);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("[CACHE] Finished: cost time ");
        sb.append(jCurrentTimeMillis2);
        sb.append(", mPriority: ");
        sb.append(this.mPriority);
        sb.append(", url key: ");
        sb.append(getKey());
        sb.append(", already exists: ");
        sb.append(this.mCounters.alreadyCachedBytes);
        sb.append(", newly cached ");
        sb.append(this.mCounters.newlyCachedBytes);
        sb.append(", content length: ");
        sb.append(this.mCounters.contentLength == -1 ? 0L : this.mCounters.contentLength);
        LogUtil.m25454i(str, sb.toString());
        this.mPriorityTaskManager.remove(this.mPriority);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mUrl.equals(((CacheTaskImpl) obj).mUrl);
    }

    public int hashCode() {
        return this.mUrl.hashCode();
    }

    @Override // com.oplus.tblplayer.cache.ICacheTask
    public boolean isFinished() {
        return this.mFinished;
    }

    @Override // com.oplus.tblplayer.cache.ICacheTask
    public void cancel() {
        LogUtil.m25450d(TAG, "[CACHE] cancel");
        this.mCancel.set(true);
    }

    private void onCacheStart() {
        ICacheListener iCacheListener = this.mListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheStart(this.mUrl);
        }
    }

    private void onCacheFinish(long OplusGLSurfaceView_15, long j2, long j3, long j4) {
        ICacheListener iCacheListener = this.mListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheFinish(this.mUrl, OplusGLSurfaceView_15, j2, j3, j4);
        }
    }

    private void onCacheError(String str) {
        ICacheListener iCacheListener = this.mListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheError(this.mUrl, 0, str);
        }
    }
}
