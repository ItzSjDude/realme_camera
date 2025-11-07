package com.oplus.tblplayer.cache;

import com.oplus.tblplayer.misc.MediaUrl;

/* loaded from: classes2.dex */
public interface ICacheManager {
    public static final long MIN_LENGTH = 1048576;

    void registerCacheListener(ICacheListener iCacheListener);

    void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2);

    void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13);

    void stopAllCache();

    void stopCache(MediaUrl mediaUrl);

    void unregisterCacheListener(ICacheListener iCacheListener);
}
