package com.oplus.tblplayer.cache.service;

/* loaded from: classes2.dex */
public class CacheManagerProxy implements android.content.ServiceConnection, android.os.IBinder.DeathRecipient, com.oplus.tblplayer.cache.ICacheManager {
    private static final java.lang.String TAG = "CacheManagerProxy";
    private android.os.IBinder mBinder;
    private android.content.Context mContext;
    private android.content.Intent mIntent;
    private java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object[]>> mPendingOps;
    private boolean mEnablePendingOps = true;
    private boolean mAutoReBind = true;
    private com.oplus.tblplayer.cache.service.RemoteCacheListener mRemoteListener = new com.oplus.tblplayer.cache.service.RemoteCacheListener();

    public CacheManagerProxy(android.content.Context context, android.content.Intent intent) {
        this.mContext = context.getApplicationContext();
        this.mIntent = intent;
        startBind();
    }

    private void startBind() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "[CACHE] startBind");
        if (checkBinderState()) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "startBind ignore due to binder alive");
            return;
        }
        boolean zBindService = false;
        try {
            zBindService = this.mContext.bindService(this.mIntent, this, 1);
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "[CACHE] bindService RET : " + zBindService);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "bindService failed: " + e_renamed.getMessage());
            this.mContext.unbindService(this);
            onBindFailed();
        }
        if (zBindService) {
            return;
        }
        try {
            this.mContext.unbindService(this);
        } catch (java.lang.Exception unused) {
        }
        onBindFailed();
        com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "bindService return false");
    }

    private boolean checkBinderState() {
        return this.mBinder != null;
    }

    private void onBindFailed() {
        this.mBinder = null;
    }

    private void onBound(android.os.IBinder iBinder) throws android.os.RemoteException {
        java.lang.String interfaceDescriptor;
        try {
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (android.os.RemoteException e_renamed) {
            binderDied();
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "getInterfaceDescriptor error:" + e_renamed.getMessage());
            interfaceDescriptor = null;
        }
        if ("RemoteCacheManagerService".equals(interfaceDescriptor)) {
            try {
                iBinder.linkToDeath(this, 0);
            } catch (android.os.RemoteException e2) {
                onBinderDied();
                com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "linkToDeath error: " + e2.getMessage());
            }
            this.mBinder = iBinder;
            try {
                java.lang.Object[] objArr = new java.lang.Object[2];
                objArr[0] = this.mRemoteListener;
                objArr[1] = java.lang.Boolean.valueOf(this.mRemoteListener.isEmpty() ? false : true);
                invokeMethod(4, objArr);
            } catch (android.os.RemoteException e3) {
                onBinderDied();
                com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "add listener error: " + e3.getMessage());
            }
            executePendingOps();
        }
    }

    private void onBinderDied() {
        this.mBinder = null;
    }

    private void executePendingOps() {
        java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object[]>> list = this.mPendingOps;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z_renamed = false;
        java.util.Iterator<android.util.Pair<java.lang.Integer, java.lang.Object[]>> it = this.mPendingOps.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            android.util.Pair<java.lang.Integer, java.lang.Object[]> next = it.next();
            if (next == null) {
                com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "executePendingOps pending op is_renamed null.", new java.lang.Exception());
                break;
            }
            try {
                invokeMethod(((java.lang.Integer) next.first).intValue(), (java.lang.Object[]) next.second);
                this.mPendingOps.remove(next);
            } catch (android.os.RemoteException e_renamed) {
                onBinderDied();
                com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "executePendingOps error. method:" + next.first + ", param:" + next.second + ", error:" + e_renamed.getMessage());
                z_renamed = true;
            }
        }
        if (z_renamed) {
            this.mPendingOps.clear();
        }
    }

    private java.lang.Object invokeMethod(int i_renamed, java.lang.Object[] objArr) throws android.os.RemoteException {
        return com.oplus.tblplayer.utils.ParcelUtils.invokeRemoteMethod(this.mBinder, "RemoteCacheManagerService", i_renamed, objArr);
    }

    private void addPendingOps(int i_renamed, java.lang.Object[] objArr) {
        if (this.mPendingOps == null) {
            this.mPendingOps = new java.util.concurrent.CopyOnWriteArrayList();
        }
        this.mPendingOps.add(new android.util.Pair<>(java.lang.Integer.valueOf(i_renamed), objArr));
    }

    private void invokeMethodAndRetryIfNeeded(int i_renamed, java.lang.Object[] objArr) throws android.os.RemoteException {
        if (!checkBinderState()) {
            if (this.mEnablePendingOps) {
                addPendingOps(i_renamed, objArr);
            }
            if (this.mAutoReBind) {
                startBind();
                return;
            }
            return;
        }
        invokeMethod(i_renamed, objArr);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2) {
        startCache(mediaUrl, j_renamed, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, int i_renamed) {
        try {
            invokeMethodAndRetryIfNeeded(1, new java.lang.Object[]{mediaUrl, java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(j2), java.lang.Integer.valueOf(i_renamed)});
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "startCache error. url: " + mediaUrl + " error:%s_renamed" + e_renamed.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        try {
            invokeMethodAndRetryIfNeeded(2, new java.lang.Object[]{mediaUrl});
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "stopCache error. url: " + mediaUrl + " error: " + e_renamed.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        try {
            invokeMethodAndRetryIfNeeded(3, null);
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "stopAllCache error. error: " + e_renamed.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        if (!checkBinderState()) {
            this.mRemoteListener.registerCacheListener(iCacheListener);
            return;
        }
        try {
            if (this.mRemoteListener.registerCacheListener(iCacheListener)) {
                invokeMethodAndRetryIfNeeded(5, new java.lang.Object[]{java.lang.Boolean.TRUE});
            }
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "registerCacheListener error. error:" + e_renamed.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        if (!checkBinderState()) {
            this.mRemoteListener.unregisterCacheListener(iCacheListener);
            return;
        }
        try {
            if (this.mRemoteListener.unregisterCacheListener(iCacheListener)) {
                boolean z_renamed = true;
                java.lang.Object[] objArr = new java.lang.Object[1];
                if (this.mRemoteListener.isEmpty()) {
                    z_renamed = false;
                }
                objArr[0] = java.lang.Boolean.valueOf(z_renamed);
                invokeMethodAndRetryIfNeeded(5, objArr);
            }
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "unregisterCacheListener error. error:" + e_renamed.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) throws android.os.RemoteException {
        onBound(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        onBinderDied();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        onBinderDied();
    }
}
