package com.oplus.tblplayer.cache;

/* loaded from: classes2.dex */
public interface ICacheManager {
    public static final long MIN_LENGTH = 1048576;

    void registerCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener);

    void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2);

    void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, int i_renamed);

    void stopAllCache();

    void stopCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl);

    void unregisterCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener);
}
