package com.oplus.tblplayer.cache.service;

/* loaded from: classes2.dex */
public class RemoteCacheListener extends com.oplus.tblplayer.remote.BaseBinderStub implements android.os.IInterface, com.oplus.tblplayer.cache.ICacheListener {
    public static final java.lang.String DESCRIPTOR = "RemoteCacheListener";
    public static final int M_ON_CACHE_ERROR = 3;
    public static final int M_ON_CACHE_FINISH = 2;
    public static final int M_ON_CACHE_START = 1;
    private static final java.lang.String TAG = "RemoteCacheListener";
    private java.util.List<com.oplus.tblplayer.cache.ICacheListener> mListener;

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this;
    }

    protected java.lang.String getDescriptor() {
        return DESCRIPTOR;
    }

    public RemoteCacheListener() {
        attachInterface(this, DESCRIPTOR);
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    protected java.lang.Object onTransactInternal(int i_renamed, java.lang.Object... objArr) throws java.io.IOException {
        return execTransact(i_renamed, objArr);
    }

    protected java.lang.Object execTransact(int i_renamed, java.lang.Object... objArr) throws java.io.IOException {
        if (i_renamed == 1) {
            onCacheStart((com.oplus.tblplayer.misc.MediaUrl) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 0));
            return null;
        }
        if (i_renamed == 2) {
            onCacheFinish((com.oplus.tblplayer.misc.MediaUrl) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 0), ((java.lang.Long) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 1)).longValue(), ((java.lang.Long) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 2)).longValue(), ((java.lang.Long) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 3)).longValue(), ((java.lang.Long) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 4)).longValue());
            return null;
        }
        if (i_renamed == 3) {
            onCacheError((com.oplus.tblplayer.misc.MediaUrl) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 0), ((java.lang.Integer) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 1)).intValue(), (java.lang.String) com.oplus.tblplayer.utils.ArgsUtil.safeGet(objArr, 2));
            return null;
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "call get unknown method index:%d_renamed" + i_renamed);
        return super.onTransactInternal(i_renamed, objArr);
    }

    public boolean registerCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        if (this.mListener == null) {
            this.mListener = new java.util.ArrayList();
        }
        if (this.mListener.contains(iCacheListener)) {
            return false;
        }
        return this.mListener.add(iCacheListener);
    }

    public boolean unregisterCacheListener(com.oplus.tblplayer.cache.ICacheListener iCacheListener) {
        if (isEmpty()) {
            return false;
        }
        return this.mListener.remove(iCacheListener);
    }

    public boolean isEmpty() {
        java.util.List<com.oplus.tblplayer.cache.ICacheListener> list = this.mListener;
        return list != null && list.isEmpty();
    }

    @Override // com.oplus.tblplayer.cache.ICacheListener
    public void onCacheStart(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        java.util.List<com.oplus.tblplayer.cache.ICacheListener> list = this.mListener;
        if (list != null) {
            java.util.Iterator<com.oplus.tblplayer.cache.ICacheListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCacheStart(mediaUrl);
            }
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheListener
    public void onCacheFinish(com.oplus.tblplayer.misc.MediaUrl mediaUrl, long j_renamed, long j2, long j3, long j4) {
        java.util.List<com.oplus.tblplayer.cache.ICacheListener> list = this.mListener;
        if (list != null) {
            java.util.Iterator<com.oplus.tblplayer.cache.ICacheListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCacheFinish(mediaUrl, j_renamed, j2, j3, j4);
            }
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheListener
    public void onCacheError(com.oplus.tblplayer.misc.MediaUrl mediaUrl, int i_renamed, java.lang.String str) {
        java.util.List<com.oplus.tblplayer.cache.ICacheListener> list = this.mListener;
        if (list != null) {
            java.util.Iterator<com.oplus.tblplayer.cache.ICacheListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCacheError(mediaUrl, i_renamed, str);
            }
        }
    }
}
