package com.oplus.tblplayer.remote;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.oplus.tblplayer.IRemoteLinker;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.utils.LogUtil;

/* loaded from: classes2.dex */
public class TBLRemotePlayerService extends Service {
    private static final String TAG = "TBLRemoteService";
    private Context mAppContext;
    private IBinder mBinder;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mAppContext = getApplicationContext();
        Globals.maybeInitialize(this.mAppContext, null);
        this.mBinder = new IRemoteLinker.Stub() { // from class: com.oplus.tblplayer.remote.TBLRemotePlayerService.1
            @Override // com.oplus.tblplayer.IRemoteLinker
            public IBinder create() throws RemoteException {
                return new RemotePlayerStub(TBLRemotePlayerService.this.mAppContext);
            }
        };
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogUtil.m25450d(TAG, "onBind");
        return this.mBinder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        LogUtil.m25450d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtil.m25450d(TAG, "onDestroy");
        super.onDestroy();
    }
}
