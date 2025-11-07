package com.oplus.tblplayer.cache.impl;

/* loaded from: classes2.dex */
public class CacheTaskImpl extends com.oplus.tblplayer.utils.executor.SafeRunnable implements com.oplus.tblplayer.cache.ICacheTask {
    private static final java.lang.String TAG = "CacheTaskImpl";
    private com.google.android.exoplayer2.upstream.cache.Cache mCache;
    private com.google.android.exoplayer2.upstream.DataSource.Factory mDataSourceFactory;
    private long mLength;
    private com.oplus.tblplayer.cache.ICacheListener mListener;
    private int mPriority;
    private com.google.android.exoplayer2.util.PriorityTaskManager mPriorityTaskManager;
    private long mStartPos;
    private com.oplus.tblplayer.misc.MediaUrl mUrl;
    private com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters mCounters = new com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters();
    private volatile boolean mFinished = false;
    private java.util.concurrent.atomic.AtomicBoolean mCancel = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.lang.String mIdentify = toString();

    public CacheTaskImpl(com.oplus.tblplayer.cache.ICacheListener iCacheListener, com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, int i_renamed) {
        this.mListener = iCacheListener;
        this.mCache = cache;
        this.mDataSourceFactory = factory;
        this.mUrl = mediaUrl;
        this.mStartPos = j_renamed;
        this.mLength = j2;
        this.mPriorityTaskManager = priorityTaskManager;
        this.mPriority = i_renamed;
    }

    @Override // com.oplus.tblplayer.cache.ICacheTask
    public java.lang.String getKey() {
        java.lang.String customCacheKey = this.mUrl.getCustomCacheKey();
        return customCacheKey == null ? this.mUrl.toString() : customCacheKey;
    }

    @Override // com.oplus.tblplayer.utils.executor.SafeRunnable
    protected void safeRun() {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        if (this.mPriority >= 0) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "Priority should not greater than PLAYBACK!");
            this.mPriority = -1;
        }
        this.mPriorityTaskManager.add(this.mPriority);
        onCacheStart();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            dataSpec = new com.google.android.exoplayer2.upstream.DataSpec(this.mUrl.getUri(), this.mStartPos, this.mLength, this.mUrl.getCustomCacheKey());
            com.google.android.exoplayer2.upstream.cache.CacheUtil.getCached(dataSpec, this.mCache, this.mCounters);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "Cache error: " + e_renamed.getMessage());
            onCacheError(e_renamed.getMessage());
        }
        if (this.mCounters.alreadyCachedBytes > 0) {
            com.oplus.tblplayer.utils.LogUtil.i_renamed(TAG, "Cache ignore due to already cached. task: " + this.mIdentify + ", url key: " + getKey() + ", alreadyCachedBytes: " + this.mCounters.alreadyCachedBytes);
            onCacheFinish(this.mCounters.contentLength, this.mCounters.alreadyCachedBytes, 0L, java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
            return;
        }
        com.google.android.exoplayer2.upstream.cache.CacheUtil.cache(dataSpec, this.mCache, new com.google.android.exoplayer2.upstream.cache.CacheDataSource(this.mCache, this.mDataSourceFactory.createDataSource()), new byte[131072], this.mPriorityTaskManager, this.mPriority, this.mCounters, this.mCancel, false);
        this.mFinished = true;
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
        onCacheFinish(this.mCounters.contentLength, this.mCounters.alreadyCachedBytes, this.mCounters.newlyCachedBytes, jCurrentTimeMillis2);
        java.lang.String str = TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
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
        com.oplus.tblplayer.utils.LogUtil.i_renamed(str, sb.toString());
        this.mPriorityTaskManager.remove(this.mPriority);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mUrl.equals(((com.oplus.tblplayer.cache.impl.CacheTaskImpl) obj).mUrl);
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
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "[CACHE] cancel");
        this.mCancel.set(true);
    }

    private void onCacheStart() {
        com.oplus.tblplayer.cache.ICacheListener iCacheListener = this.mListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheStart(this.mUrl);
        }
    }

    private void onCacheFinish(long j_renamed, long j2, long j3, long j4) {
        com.oplus.tblplayer.cache.ICacheListener iCacheListener = this.mListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheFinish(this.mUrl, j_renamed, j2, j3, j4);
        }
    }

    private void onCacheError(java.lang.String str) {
        com.oplus.tblplayer.cache.ICacheListener iCacheListener = this.mListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheError(this.mUrl, 0, str);
        }
    }
}
