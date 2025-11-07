package com.oplus.epona.ipc.local;

import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.epona.Call;
import com.oplus.epona.Epona;
import com.oplus.epona.IRemoteTransfer;
import com.oplus.epona.ITransferCallback;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.utils.Logger;

/* loaded from: classes2.dex */
public class RemoteTransfer extends IRemoteTransfer.Stub {
    public static final String APP_PLATFORM_PACKAGE_NAME = "com.oplus.appplatform";
    private static final String TAG = "RemoteTransfer";
    private static volatile RemoteTransfer sInstance;

    private RemoteTransfer() {
    }

    public static RemoteTransfer getInstance() {
        if (sInstance == null) {
            synchronized (RemoteTransfer.class) {
                if (sInstance == null) {
                    sInstance = new RemoteTransfer();
                }
            }
        }
        return sInstance;
    }

    @Override // com.oplus.epona.IRemoteTransfer
    public Response call(Request request) throws RemoteException {
        return Epona.newCall(request).execute();
    }

    @Override // com.oplus.epona.IRemoteTransfer
    public void asyncCall(Request request, final ITransferCallback iTransferCallback) throws RemoteException {
        Epona.newCall(request).asyncExecute(new Call.Callback() { // from class: com.oplus.epona.ipc.local.-$$Lambda$RemoteTransfer$TIvwbbPl8xdwXDrc8ucAqeagrKg
            @Override // com.oplus.epona.Call.Callback
            public final void onReceive(Response response) {
                RemoteTransfer.lambda$asyncCall$0(iTransferCallback, response);
            }
        });
    }

    static /* synthetic */ void lambda$asyncCall$0(ITransferCallback iTransferCallback, Response response) {
        try {
            iTransferCallback.onReceive(response);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            Logger.m25000e(TAG, "failed to asyncCall and exception is %s", COUIBaseListPopupWindow_8.toString());
        }
    }

    @Override // com.oplus.epona.IRemoteTransfer.Stub, android.os.Binder
    public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        try {
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            Logger.m25000e(TAG, "onTransact Exception: " + COUIBaseListPopupWindow_8.toString(), new Object[0]);
            throw COUIBaseListPopupWindow_8;
        }
    }
}
