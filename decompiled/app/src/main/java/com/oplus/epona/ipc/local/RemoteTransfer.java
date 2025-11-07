package com.oplus.epona.ipc.local;

/* loaded from: classes2.dex */
public class RemoteTransfer extends com.oplus.epona.IRemoteTransfer.Stub {
    public static final java.lang.String APP_PLATFORM_PACKAGE_NAME = "com.oplus.appplatform";
    private static final java.lang.String TAG = "RemoteTransfer";
    private static volatile com.oplus.epona.ipc.local.RemoteTransfer sInstance;

    private RemoteTransfer() {
    }

    public static com.oplus.epona.ipc.local.RemoteTransfer getInstance() {
        if (sInstance == null) {
            synchronized (com.oplus.epona.ipc.local.RemoteTransfer.class) {
                if (sInstance == null) {
                    sInstance = new com.oplus.epona.ipc.local.RemoteTransfer();
                }
            }
        }
        return sInstance;
    }

    @Override // com.oplus.epona.IRemoteTransfer
    public com.oplus.epona.Response call(com.oplus.epona.Request request) throws android.os.RemoteException {
        return com.oplus.epona.Epona.newCall(request).execute();
    }

    @Override // com.oplus.epona.IRemoteTransfer
    public void asyncCall(com.oplus.epona.Request request, final com.oplus.epona.ITransferCallback iTransferCallback) throws android.os.RemoteException {
        com.oplus.epona.Epona.newCall(request).asyncExecute(new com.oplus.epona.Call.Callback() { // from class: com.oplus.epona.ipc.local.-$$Lambda$RemoteTransfer$TIvwbbPl8xdwXDrc8ucAqeagrKg
            @Override // com.oplus.epona.Call.Callback
            public final void onReceive(com.oplus.epona.Response response) {
                com.oplus.epona.ipc.local.RemoteTransfer.lambda$asyncCall$0(iTransferCallback, response);
            }
        });
    }

    static /* synthetic */ void lambda$asyncCall$0(com.oplus.epona.ITransferCallback iTransferCallback, com.oplus.epona.Response response) {
        try {
            iTransferCallback.onReceive(response);
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "failed to asyncCall and exception is_renamed %s_renamed", e_renamed.toString());
        }
    }

    @Override // com.oplus.epona.IRemoteTransfer.Stub, android.os.Binder
    public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        try {
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        } catch (java.lang.RuntimeException e_renamed) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "onTransact Exception: " + e_renamed.toString(), new java.lang.Object[0]);
            throw e_renamed;
        }
    }
}
