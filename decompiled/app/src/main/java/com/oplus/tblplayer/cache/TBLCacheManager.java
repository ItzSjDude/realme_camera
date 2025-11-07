package com.oplus.tblplayer.cache;

/* loaded from: classes2.dex */
public class TBLCacheManager implements com.oplus.tblplayer.cache.ICacheManager {
    private static final java.lang.String TAG = "TBLCacheManager";
    private static volatile com.oplus.tblplayer.cache.TBLCacheManager sCacheManager;
    private com.oplus.tblplayer.cache.ICacheManager mCacheManagerProxy;

    private TBLCacheManager(android.content.Context context) {
        com.oplus.tblplayer.config.Globals.maybeInitialize(context, null);
        this.mCacheManagerProxy = new com.oplus.tblplayer.cache.service.CacheManagerProxy(context, new android.content.Intent(context, (java.lang.Class<?>) com.oplus.tblplayer.cache.service.RemoteCacheManagerService.class));
    }

    public static com.oplus.tblplayer.cache.TBLCacheManager getCacheManager(android.content.Context context) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "getCacheManager pre-cache enable is_renamed " + com.oplus.tblplayer.config.Globals.getPreCacheEnable());
        com.oplus.tblplayer.utils.AssertUtil.checkState(com.oplus.tblplayer.config.Globals.getPreCacheEnable());
        if (com.oplus.tblplayer.config.Globals.getPreCacheEnable() && sCacheManager == null) {
            synchronized (com.oplus.tblplayer.TBLPlayerManager.class) {
                if (sCacheManager == null) {
                    sCacheManager = new com.oplus.tblplayer.cache.TBLCacheManager(context);
                }
            }
        }
        return sCacheManager;
    }

    public void startCache(java.lang.String str, long j_renamed, long j2) {
        startCache(new com.oplus.tblplayer.misc.MediaUrl.Builder(str).build(), j_renamed, j2);
    }

    public void startCache(java.lang.String str, long j_renamed, long j2, int i_renamed) {
        startCache(new com.oplus.tblplayer.misc.MediaUrl.Builder(str).build(), j_renamed, j2, i_renamed);
    }

    public void stopCache(java.lang.String str) {
        stopCache(new com.oplus.tblplayer.misc.MediaUrl.Builder(str).build());
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2) {
        this.mCacheManagerProxy.startCache(mediaUrl, j_renamed, j2);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, int i_renamed) {
        this.mCacheManagerProxy.startCache(mediaUrl, j_renamed, j2, i_renamed);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        this.mCacheManagerProxy.stopCache(mediaUrl);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        this.mCacheManagerProxy.stopAllCache();
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        this.mCacheManagerProxy.registerCacheListener(iCacheListener);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        this.mCacheManagerProxy.unregisterCacheListener(iCacheListener);
    }
}
