package com.oplus.epona.interceptor;

import android.os.RemoteException;
import com.oplus.epona.Call;
import com.oplus.epona.Epona;
import com.oplus.epona.IRemoteTransfer;
import com.oplus.epona.ITransferCallback;
import com.oplus.epona.Interceptor;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.utils.Logger;

/* loaded from: classes2.dex */
public class IPCInterceptor implements Interceptor {
    private static final String TAG = "IPCInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        IRemoteTransfer iRemoteTransferAsInterface = IRemoteTransfer.Stub.asInterface(Epona.getTransferController().fetch(request.getComponentName()));
        if (iRemoteTransferAsInterface != null) {
            final Call.Callback callback = chain.callback();
            try {
                if (chain.isAsync()) {
                    iRemoteTransferAsInterface.asyncCall(request, new ITransferCallback.Stub() { // from class: com.oplus.epona.interceptor.IPCInterceptor.1
                        @Override // com.oplus.epona.ITransferCallback
                        public void onReceive(Response response) throws RemoteException {
                            callback.onReceive(response);
                        }
                    });
                } else {
                    callback.onReceive(iRemoteTransferAsInterface.call(request));
                }
                return;
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                Logger.m25000e(TAG, "fail to call %s#%s and exception is %s", request.getComponentName(), request.getActionName(), COUIBaseListPopupWindow_8.toString());
                callback.onReceive(Response.defaultErrorResponse());
                return;
            }
        }
        chain.proceed();
    }
}
