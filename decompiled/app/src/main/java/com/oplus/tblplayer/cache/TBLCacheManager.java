package com.oplus.tblplayer.cache;

import android.content.Context;
import android.content.Intent;
import com.oplus.tblplayer.TBLPlayerManager;
import com.oplus.tblplayer.cache.service.CacheManagerProxy;
import com.oplus.tblplayer.cache.service.RemoteCacheManagerService;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.AssertUtil;
import com.oplus.tblplayer.utils.LogUtil;

/* loaded from: classes2.dex */
public class TBLCacheManager implements ICacheManager {
    private static final String TAG = "TBLCacheManager";
    private static volatile TBLCacheManager sCacheManager;
    private ICacheManager mCacheManagerProxy;

    private TBLCacheManager(Context context) {
        Globals.maybeInitialize(context, null);
        this.mCacheManagerProxy = new CacheManagerProxy(context, new Intent(context, (Class<?>) RemoteCacheManagerService.class));
    }

    public static TBLCacheManager getCacheManager(Context context) {
        LogUtil.m25450d(TAG, "getCacheManager pre-cache enable is " + Globals.getPreCacheEnable());
        AssertUtil.checkState(Globals.getPreCacheEnable());
        if (Globals.getPreCacheEnable() && sCacheManager == null) {
            synchronized (TBLPlayerManager.class) {
                if (sCacheManager == null) {
                    sCacheManager = new TBLCacheManager(context);
                }
            }
        }
        return sCacheManager;
    }

    public void startCache(String str, long OplusGLSurfaceView_15, long j2) {
        startCache(new MediaUrl.Builder(str).build(), OplusGLSurfaceView_15, j2);
    }

    public void startCache(String str, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        startCache(new MediaUrl.Builder(str).build(), OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
    }

    public void stopCache(String str) {
        stopCache(new MediaUrl.Builder(str).build());
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2) {
        this.mCacheManagerProxy.startCache(mediaUrl, OplusGLSurfaceView_15, j2);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        this.mCacheManagerProxy.startCache(mediaUrl, OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        this.mCacheManagerProxy.stopCache(mediaUrl);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        this.mCacheManagerProxy.stopAllCache();
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        this.mCacheManagerProxy.registerCacheListener(iCacheListener);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        this.mCacheManagerProxy.unregisterCacheListener(iCacheListener);
    }
}
