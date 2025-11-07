package com.oplus.tblplayer.cache.service;

/* loaded from: classes2.dex */
public class CacheManagerStub extends com.oplus.tblplayer.remote.BaseBinderStub implements android.os.IInterface, com.oplus.tblplayer.cache.ICacheManager {
    private static final java.lang.String TAG = "CacheManagerStub";
    private com.oplus.tblplayer.cache.ICacheManager mCacheManager;
    private boolean mHasListener;
    private com.oplus.tblplayer.cache.ICacheListener mListenerDispatcher = new com.oplus.tblplayer.cache.ICacheListener() { // from class: com.oplus.tblplayer.cache.service.CacheManagerStub.1
        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheStart(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
            if (com.oplus.tblplayer.cache.service.CacheManagerStub.this.checkListenerState()) {
                com.oplus.tblplayer.cache.service.CacheManagerStub.this.invokeRemoteMethod(1, mediaUrl);
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheFinish(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, long j3, long j4) {
            if (com.oplus.tblplayer.cache.service.CacheManagerStub.this.checkListenerState()) {
                com.oplus.tblplayer.cache.service.CacheManagerStub.this.invokeRemoteMethod(2, mediaUrl, java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j4));
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheError(com.oplus.tblplayer.misc.MediaUrl mediaUrl, int i_renamed, java.lang.String str) {
            if (com.oplus.tblplayer.cache.service.CacheManagerStub.this.checkListenerState()) {
                com.oplus.tblplayer.cache.service.CacheManagerStub.this.invokeRemoteMethod(3, mediaUrl, java.lang.Integer.valueOf(i_renamed), str);
            }
        }
    };
    private android.os.IBinder mRemoteListener;

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this;
    }

    protected java.lang.String getDescriptor() {
        return "RemoteCacheManagerService";
    }

    public CacheManagerStub(android.content.Context context) {
        attachInterface(this, "RemoteCacheManagerService");
        this.mCacheManager = new com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl(context);
        this.mCacheManager.registerCacheListener(this.mListenerDispatcher);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2) {
        startCache(mediaUrl, j_renamed, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, int i_renamed) {
        this.mCacheManager.startCache(mediaUrl, j_renamed, j2, i_renamed);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        this.mCacheManager.stopCache(mediaUrl);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        this.mCacheManager.stopAllCache();
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        this.mRemoteListener = (android.os.IBinder) iCacheListener;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        this.mRemoteListener = null;
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    protected java.lang.Object onTransactInternal(int i_renamed, java.lang.Object... objArr) throws java.io.IOException {
        if (i_renamed == 1) {
            if (objArr == null || objArr.length < 1) {
                com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "binder call startCache ignore due to illegalArgument");
                return null;
            }
            java.lang.Long l_renamed = (java.lang.Long) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 1);
            java.lang.Long l2 = (java.lang.Long) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 2);
            java.lang.Integer num = (java.lang.Integer) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 3);
            if (l_renamed == null || l_renamed.longValue() < 0) {
                l_renamed = 0L;
            }
            if (l2 == null) {
                l2 = 1048576L;
            }
            startCache((com.oplus.tblplayer.misc.MediaUrl) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 0), l_renamed.longValue(), l2.longValue(), num.intValue());
            return null;
        }
        if (i_renamed == 2) {
            stopCache((com.oplus.tblplayer.misc.MediaUrl) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 0));
            return null;
        }
        if (i_renamed == 3) {
            stopAllCache();
            return null;
        }
        if (i_renamed == 4) {
            registerRemoteCacheListener((android.os.IBinder) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 0));
            setHasListener(((java.lang.Boolean) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 1)).booleanValue());
            return null;
        }
        if (i_renamed == 5) {
            setHasListener(((java.lang.Boolean) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 0)).booleanValue());
            return null;
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "binder call get unknown method index:" + i_renamed);
        return super.onTransactInternal(i_renamed, objArr);
    }

    private void registerRemoteCacheListener(android.os.IBinder iBinder) {
        this.mRemoteListener = iBinder;
    }

    private void setHasListener(boolean z_renamed) {
        this.mHasListener = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkListenerState() {
        return this.mRemoteListener != null && this.mHasListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRemoteMethod(int i_renamed, java.lang.Object... objArr) {
        try {
            com.oplus.tblplayer.utils.ParcelUtils.invokeRemoteMethod(this.mRemoteListener, com.oplus.tblplayer.cache.service.RemoteCacheListener.DESCRIPTOR, i_renamed, objArr);
        } catch (android.os.RemoteException unused) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "invokeRemoteMethod error.");
        }
    }
}
