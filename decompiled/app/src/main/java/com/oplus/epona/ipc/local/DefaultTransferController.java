package com.oplus.epona.ipc.local;

/* loaded from: classes2.dex */
public class DefaultTransferController implements com.oplus.epona.ipc.local.RemoteTransferController {
    private static final java.lang.String TAG = "DefaultTransferController";
    private final java.util.Map<java.lang.String, android.os.IBinder> mBinderCache = new java.util.HashMap();

    @Override // com.oplus.epona.ipc.local.RemoteTransferController
    public void register(java.lang.String str, java.lang.String str2, android.os.IBinder iBinder) {
        boolean zRegisterRemoteTransfer;
        if (!dispatcherProviderExist()) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "DispatcherProvider is_renamed not exist", new java.lang.Object[0]);
            return;
        }
        android.content.Context context = com.oplus.epona.Epona.getContext();
        if ("com.oplus.appplatform".equals(context.getPackageName())) {
            zRegisterRemoteTransfer = com.oplus.epona.ipc.remote.Dispatcher.getInstance().registerRemoteTransfer(str, iBinder, "com.oplus.appplatform");
        } else {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(com.oplus.epona.Constants.TRANSFER_KEY, str);
            bundle.putBinder(com.oplus.epona.Constants.TRANSFER_VALUE, iBinder);
            android.os.Bundle bundleCall = context.getContentResolver().call(com.oplus.epona.Constants.DISPATCHER_PROVIDER_URI, com.oplus.epona.Constants.REGISTER_TRANSFER, (java.lang.String) null, bundle);
            zRegisterRemoteTransfer = bundleCall != null ? bundleCall.getBoolean(com.oplus.epona.Constants.REGISTER_TRANSFER_RESULT_KEY) : false;
        }
        if (zRegisterRemoteTransfer) {
            return;
        }
        com.oplus.epona.utils.Logger.w_renamed(TAG, "Register " + str + "==>" + str2 + " failed for \"" + str + "\" is_renamed already registered", new java.lang.Object[0]);
    }

    @Override // com.oplus.epona.ipc.local.RemoteTransferController
    public android.os.IBinder fetch(final java.lang.String str) throws java.lang.Throwable {
        android.os.IBinder binder = this.mBinderCache.get(str);
        if (binder == null) {
            android.content.Context context = com.oplus.epona.Epona.getContext();
            if ("com.oplus.appplatform".equals(context.getPackageName())) {
                binder = com.oplus.epona.ipc.remote.Dispatcher.getInstance().findRemoteTransfer(str);
            } else {
                android.os.Bundle bundleFindRemoteBundle = com.oplus.epona.utils.ProviderUtils.findRemoteBundle(context, str);
                if (bundleFindRemoteBundle != null) {
                    binder = bundleFindRemoteBundle.getBinder(com.oplus.epona.Constants.TRANSFER_VALUE);
                }
            }
            if (binder != null) {
                this.mBinderCache.put(str, binder);
                try {
                    binder.linkToDeath(new android.os.IBinder.DeathRecipient() { // from class: com.oplus.epona.ipc.local.-$$Lambda$DefaultTransferController$iQaOQeA8ODA3YlGPUXg1M8DkhL4
                        @Override // android.os.IBinder.DeathRecipient
                        public final void binderDied() {
                            this.f_renamed$0.lambda$fetch$0$DefaultTransferController(str);
                        }
                    }, 0);
                } catch (android.os.RemoteException e_renamed) {
                    com.oplus.epona.utils.Logger.w_renamed(TAG, e_renamed.toString(), new java.lang.Object[0]);
                }
            } else {
                com.oplus.epona.utils.Logger.e_renamed(TAG, "Get remote binder null. ComponentName : %s_renamed", str);
            }
        }
        return binder;
    }

    public /* synthetic */ void lambda$fetch$0$DefaultTransferController(java.lang.String str) {
        this.mBinderCache.remove(str);
    }

    public java.lang.String remoteSnapshot() {
        android.os.Bundle bundleCall;
        if (dispatcherProviderExist() && (bundleCall = com.oplus.epona.Epona.getContext().getContentResolver().call(com.oplus.epona.Constants.DISPATCHER_PROVIDER_URI, com.oplus.epona.Constants.REMOTE_SNAPSHOT, (java.lang.String) null, (android.os.Bundle) null)) != null) {
            return bundleCall.getString(com.oplus.epona.Constants.REMOTE_SNAPSHOT_KEY);
        }
        return null;
    }

    private boolean dispatcherProviderExist() {
        android.content.Context context = com.oplus.epona.Epona.getContext();
        return (context == null || context.getPackageManager().resolveContentProvider(com.oplus.epona.Constants.DISPATCHER_PROVIDER_URI, 131072) == null) ? false : true;
    }
}
