package com.oplus.epona.ipc.local;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.oplus.epona.Constants;
import com.oplus.epona.Epona;
import com.oplus.epona.ipc.remote.Dispatcher;
import com.oplus.epona.utils.Logger;
import com.oplus.epona.utils.ProviderUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DefaultTransferController implements RemoteTransferController {
    private static final String TAG = "DefaultTransferController";
    private final Map<String, IBinder> mBinderCache = new HashMap();

    @Override // com.oplus.epona.ipc.local.RemoteTransferController
    public void register(String str, String str2, IBinder iBinder) {
        boolean zRegisterRemoteTransfer;
        if (!dispatcherProviderExist()) {
            Logger.m24999d(TAG, "DispatcherProvider is not exist", new Object[0]);
            return;
        }
        Context context = Epona.getContext();
        if ("com.oplus.appplatform".equals(context.getPackageName())) {
            zRegisterRemoteTransfer = Dispatcher.getInstance().registerRemoteTransfer(str, iBinder, "com.oplus.appplatform");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.TRANSFER_KEY, str);
            bundle.putBinder(Constants.TRANSFER_VALUE, iBinder);
            Bundle bundleCall = context.getContentResolver().call(Constants.DISPATCHER_PROVIDER_URI, Constants.REGISTER_TRANSFER, (String) null, bundle);
            zRegisterRemoteTransfer = bundleCall != null ? bundleCall.getBoolean(Constants.REGISTER_TRANSFER_RESULT_KEY) : false;
        }
        if (zRegisterRemoteTransfer) {
            return;
        }
        Logger.m25002w(TAG, "Register " + str + "==>" + str2 + " failed for \"" + str + "\" is already registered", new Object[0]);
    }

    @Override // com.oplus.epona.ipc.local.RemoteTransferController
    public IBinder fetch(final String str) throws Throwable {
        IBinder binder = this.mBinderCache.get(str);
        if (binder == null) {
            Context context = Epona.getContext();
            if ("com.oplus.appplatform".equals(context.getPackageName())) {
                binder = Dispatcher.getInstance().findRemoteTransfer(str);
            } else {
                Bundle bundleFindRemoteBundle = ProviderUtils.findRemoteBundle(context, str);
                if (bundleFindRemoteBundle != null) {
                    binder = bundleFindRemoteBundle.getBinder(Constants.TRANSFER_VALUE);
                }
            }
            if (binder != null) {
                this.mBinderCache.put(str, binder);
                try {
                    binder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.oplus.epona.ipc.local.-$$Lambda$DefaultTransferController$iQaOQeA8ODA3YlGPUXg1M8DkhL4
                        @Override // android.os.IBinder.DeathRecipient
                        public final void binderDied() {
                            this.COUIBaseListPopupWindow_12$0.lambda$fetch$0$DefaultTransferController(str);
                        }
                    }, 0);
                } catch (RemoteException COUIBaseListPopupWindow_8) {
                    Logger.m25002w(TAG, COUIBaseListPopupWindow_8.toString(), new Object[0]);
                }
            } else {
                Logger.m25000e(TAG, "Get remote binder null. ComponentName : %s", str);
            }
        }
        return binder;
    }

    public /* synthetic */ void lambda$fetch$0$DefaultTransferController(String str) {
        this.mBinderCache.remove(str);
    }

    public String remoteSnapshot() {
        Bundle bundleCall;
        if (dispatcherProviderExist() && (bundleCall = Epona.getContext().getContentResolver().call(Constants.DISPATCHER_PROVIDER_URI, Constants.REMOTE_SNAPSHOT, (String) null, (Bundle) null)) != null) {
            return bundleCall.getString(Constants.REMOTE_SNAPSHOT_KEY);
        }
        return null;
    }

    private boolean dispatcherProviderExist() {
        Context context = Epona.getContext();
        return (context == null || context.getPackageManager().resolveContentProvider(Constants.DISPATCHER_PROVIDER_URI, 131072) == null) ? false : true;
    }
}
