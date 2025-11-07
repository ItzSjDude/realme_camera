package com.oplus.tblplayer.cache.service;

/* loaded from: classes2.dex */
public class RemoteCacheManagerService extends android.app.Service {
    protected static final java.lang.String DESCRIPTOR = "RemoteCacheManagerService";
    protected static final int M_ADD_LISTENER = 4;
    protected static final int M_LISTENER_FLAG = 5;
    protected static final int M_START_CACHE = 1;
    protected static final int M_STOP_ALL = 3;
    protected static final int M_STOP_CACHE = 2;
    private android.content.Context mAppContext;
    private android.os.IBinder mBinder;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mAppContext = getApplicationContext();
        com.oplus.tblplayer.config.Globals.maybeInitialize(this.mAppContext, null);
        this.mBinder = createService();
    }

    protected android.os.IBinder createService() {
        return new com.oplus.tblplayer.cache.service.CacheManagerStub(this.mAppContext);
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.mBinder;
    }
}
