package com.oplus.tblplayer.remote;

/* loaded from: classes2.dex */
public class TBLRemotePlayerService extends android.app.Service {
    private static final java.lang.String TAG = "TBLRemoteService";
    private android.content.Context mAppContext;
    private android.os.IBinder mBinder;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mAppContext = getApplicationContext();
        com.oplus.tblplayer.config.Globals.maybeInitialize(this.mAppContext, null);
        this.mBinder = new com.oplus.tblplayer.IRemoteLinker.Stub() { // from class: com.oplus.tblplayer.remote.TBLRemotePlayerService.1
            @Override // com.oplus.tblplayer.IRemoteLinker
            public android.os.IBinder create() throws android.os.RemoteException {
                return new com.oplus.tblplayer.remote.RemotePlayerStub(com.oplus.tblplayer.remote.TBLRemotePlayerService.this.mAppContext);
            }
        };
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onBind");
        return this.mBinder;
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onDestroy");
        super.onDestroy();
    }
}
