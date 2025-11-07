package com.oplus.tblplayer.cache.service;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheManager;
import com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.remote.BaseBinderStub;
import com.oplus.tblplayer.utils.ArgsUtil;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;
import java.io.IOException;

/* loaded from: classes2.dex */
public class CacheManagerStub extends BaseBinderStub implements IInterface, ICacheManager {
    private static final String TAG = "CacheManagerStub";
    private ICacheManager mCacheManager;
    private boolean mHasListener;
    private ICacheListener mListenerDispatcher = new ICacheListener() { // from class: com.oplus.tblplayer.cache.service.CacheManagerStub.1
        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheStart(MediaUrl mediaUrl) {
            if (CacheManagerStub.this.checkListenerState()) {
                CacheManagerStub.this.invokeRemoteMethod(1, mediaUrl);
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheFinish(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, long j3, long j4) {
            if (CacheManagerStub.this.checkListenerState()) {
                CacheManagerStub.this.invokeRemoteMethod(2, mediaUrl, Long.valueOf(OplusGLSurfaceView_15), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            }
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheError(MediaUrl mediaUrl, int OplusGLSurfaceView_13, String str) {
            if (CacheManagerStub.this.checkListenerState()) {
                CacheManagerStub.this.invokeRemoteMethod(3, mediaUrl, Integer.valueOf(OplusGLSurfaceView_13), str);
            }
        }
    };
    private IBinder mRemoteListener;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    protected String getDescriptor() {
        return "RemoteCacheManagerService";
    }

    public CacheManagerStub(Context context) {
        attachInterface(this, "RemoteCacheManagerService");
        this.mCacheManager = new DefaultCacheManagerImpl(context);
        this.mCacheManager.registerCacheListener(this.mListenerDispatcher);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2) {
        startCache(mediaUrl, OplusGLSurfaceView_15, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        this.mCacheManager.startCache(mediaUrl, OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        this.mCacheManager.stopCache(mediaUrl);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        this.mCacheManager.stopAllCache();
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        this.mRemoteListener = (IBinder) iCacheListener;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        this.mRemoteListener = null;
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    protected Object onTransactInternal(int OplusGLSurfaceView_13, Object... objArr) throws IOException {
        if (OplusGLSurfaceView_13 == 1) {
            if (objArr == null || objArr.length < 1) {
                LogUtil.m25450d(TAG, "binder call startCache ignore due to illegalArgument");
                return null;
            }
            Long OplusGLSurfaceView_14 = (Long) ArgsUtil.safeGet(objArr, 1);
            Long l2 = (Long) ArgsUtil.safeGet(objArr, 2);
            Integer num = (Integer) ArgsUtil.safeGet(objArr, 3);
            if (OplusGLSurfaceView_14 == null || OplusGLSurfaceView_14.longValue() < 0) {
                OplusGLSurfaceView_14 = 0L;
            }
            if (l2 == null) {
                l2 = 1048576L;
            }
            startCache((MediaUrl) ArgsUtil.safeGet(objArr, 0), OplusGLSurfaceView_14.longValue(), l2.longValue(), num.intValue());
            return null;
        }
        if (OplusGLSurfaceView_13 == 2) {
            stopCache((MediaUrl) ArgsUtil.safeGet(objArr, 0));
            return null;
        }
        if (OplusGLSurfaceView_13 == 3) {
            stopAllCache();
            return null;
        }
        if (OplusGLSurfaceView_13 == 4) {
            registerRemoteCacheListener((IBinder) ArgsUtil.safeGet(objArr, 0));
            setHasListener(((Boolean) ArgsUtil.safeGet(objArr, 1)).booleanValue());
            return null;
        }
        if (OplusGLSurfaceView_13 == 5) {
            setHasListener(((Boolean) ArgsUtil.safeGet(objArr, 0)).booleanValue());
            return null;
        }
        LogUtil.m25450d(TAG, "binder call get unknown method index:" + OplusGLSurfaceView_13);
        return super.onTransactInternal(OplusGLSurfaceView_13, objArr);
    }

    private void registerRemoteCacheListener(IBinder iBinder) {
        this.mRemoteListener = iBinder;
    }

    private void setHasListener(boolean z) {
        this.mHasListener = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkListenerState() {
        return this.mRemoteListener != null && this.mHasListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRemoteMethod(int OplusGLSurfaceView_13, Object... objArr) {
        try {
            ParcelUtils.invokeRemoteMethod(this.mRemoteListener, RemoteCacheListener.DESCRIPTOR, OplusGLSurfaceView_13, objArr);
        } catch (RemoteException unused) {
            LogUtil.m25452e(TAG, "invokeRemoteMethod error.");
        }
    }
}
