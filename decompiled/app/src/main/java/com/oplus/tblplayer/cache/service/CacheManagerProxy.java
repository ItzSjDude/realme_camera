package com.oplus.tblplayer.cache.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Pair;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheManager;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class CacheManagerProxy implements ServiceConnection, IBinder.DeathRecipient, ICacheManager {
    private static final String TAG = "CacheManagerProxy";
    private IBinder mBinder;
    private Context mContext;
    private Intent mIntent;
    private List<Pair<Integer, Object[]>> mPendingOps;
    private boolean mEnablePendingOps = true;
    private boolean mAutoReBind = true;
    private RemoteCacheListener mRemoteListener = new RemoteCacheListener();

    public CacheManagerProxy(Context context, Intent intent) {
        this.mContext = context.getApplicationContext();
        this.mIntent = intent;
        startBind();
    }

    private void startBind() {
        LogUtil.m25450d(TAG, "[CACHE] startBind");
        if (checkBinderState()) {
            LogUtil.m25450d(TAG, "startBind ignore due to binder alive");
            return;
        }
        boolean zBindService = false;
        try {
            zBindService = this.mContext.bindService(this.mIntent, this, 1);
            LogUtil.m25450d(TAG, "[CACHE] bindService RET : " + zBindService);
        } catch (Exception COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "bindService failed: " + COUIBaseListPopupWindow_8.getMessage());
            this.mContext.unbindService(this);
            onBindFailed();
        }
        if (zBindService) {
            return;
        }
        try {
            this.mContext.unbindService(this);
        } catch (Exception unused) {
        }
        onBindFailed();
        LogUtil.m25452e(TAG, "bindService return false");
    }

    private boolean checkBinderState() {
        return this.mBinder != null;
    }

    private void onBindFailed() {
        this.mBinder = null;
    }

    private void onBound(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor;
        try {
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            binderDied();
            LogUtil.m25452e(TAG, "getInterfaceDescriptor error:" + COUIBaseListPopupWindow_8.getMessage());
            interfaceDescriptor = null;
        }
        if ("RemoteCacheManagerService".equals(interfaceDescriptor)) {
            try {
                iBinder.linkToDeath(this, 0);
            } catch (RemoteException e2) {
                onBinderDied();
                LogUtil.m25452e(TAG, "linkToDeath error: " + e2.getMessage());
            }
            this.mBinder = iBinder;
            try {
                Object[] objArr = new Object[2];
                objArr[0] = this.mRemoteListener;
                objArr[1] = Boolean.valueOf(this.mRemoteListener.isEmpty() ? false : true);
                invokeMethod(4, objArr);
            } catch (RemoteException e3) {
                onBinderDied();
                LogUtil.m25452e(TAG, "add listener error: " + e3.getMessage());
            }
            executePendingOps();
        }
    }

    private void onBinderDied() {
        this.mBinder = null;
    }

    private void executePendingOps() {
        List<Pair<Integer, Object[]>> list = this.mPendingOps;
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = false;
        Iterator<Pair<Integer, Object[]>> it = this.mPendingOps.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair<Integer, Object[]> next = it.next();
            if (next == null) {
                LogUtil.m25451d(TAG, "executePendingOps pending op is null.", new Exception());
                break;
            }
            try {
                invokeMethod(((Integer) next.first).intValue(), (Object[]) next.second);
                this.mPendingOps.remove(next);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                onBinderDied();
                LogUtil.m25452e(TAG, "executePendingOps error. method:" + next.first + ", param:" + next.second + ", error:" + COUIBaseListPopupWindow_8.getMessage());
                z = true;
            }
        }
        if (z) {
            this.mPendingOps.clear();
        }
    }

    private Object invokeMethod(int OplusGLSurfaceView_13, Object[] objArr) throws RemoteException {
        return ParcelUtils.invokeRemoteMethod(this.mBinder, "RemoteCacheManagerService", OplusGLSurfaceView_13, objArr);
    }

    private void addPendingOps(int OplusGLSurfaceView_13, Object[] objArr) {
        if (this.mPendingOps == null) {
            this.mPendingOps = new CopyOnWriteArrayList();
        }
        this.mPendingOps.add(new Pair<>(Integer.valueOf(OplusGLSurfaceView_13), objArr));
    }

    private void invokeMethodAndRetryIfNeeded(int OplusGLSurfaceView_13, Object[] objArr) throws RemoteException {
        if (!checkBinderState()) {
            if (this.mEnablePendingOps) {
                addPendingOps(OplusGLSurfaceView_13, objArr);
            }
            if (this.mAutoReBind) {
                startBind();
                return;
            }
            return;
        }
        invokeMethod(OplusGLSurfaceView_13, objArr);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2) {
        startCache(mediaUrl, OplusGLSurfaceView_15, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        try {
            invokeMethodAndRetryIfNeeded(1, new Object[]{mediaUrl, Long.valueOf(OplusGLSurfaceView_15), Long.valueOf(j2), Integer.valueOf(OplusGLSurfaceView_13)});
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "startCache error. url: " + mediaUrl + " error:%s" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        try {
            invokeMethodAndRetryIfNeeded(2, new Object[]{mediaUrl});
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "stopCache error. url: " + mediaUrl + " error: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        try {
            invokeMethodAndRetryIfNeeded(3, null);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "stopAllCache error. error: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        if (!checkBinderState()) {
            this.mRemoteListener.registerCacheListener(iCacheListener);
            return;
        }
        try {
            if (this.mRemoteListener.registerCacheListener(iCacheListener)) {
                invokeMethodAndRetryIfNeeded(5, new Object[]{Boolean.TRUE});
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "registerCacheListener error. error:" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        if (!checkBinderState()) {
            this.mRemoteListener.unregisterCacheListener(iCacheListener);
            return;
        }
        try {
            if (this.mRemoteListener.unregisterCacheListener(iCacheListener)) {
                boolean z = true;
                Object[] objArr = new Object[1];
                if (this.mRemoteListener.isEmpty()) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                invokeMethodAndRetryIfNeeded(5, objArr);
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "unregisterCacheListener error. error:" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        onBound(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        onBinderDied();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        onBinderDied();
    }
}
