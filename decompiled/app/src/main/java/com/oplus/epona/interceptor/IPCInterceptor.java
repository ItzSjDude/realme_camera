package com.oplus.epona.interceptor;

/* loaded from: classes2.dex */
public class IPCInterceptor implements com.oplus.epona.Interceptor {
    private static final java.lang.String TAG = "IPCInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(com.oplus.epona.Interceptor.Chain chain) {
        com.oplus.epona.Request request = chain.request();
        com.oplus.epona.IRemoteTransfer iRemoteTransferAsInterface = com.oplus.epona.IRemoteTransfer.Stub.asInterface(com.oplus.epona.Epona.getTransferController().fetch(request.getComponentName()));
        if (iRemoteTransferAsInterface != null) {
            final com.oplus.epona.Call.Callback callback = chain.callback();
            try {
                if (chain.isAsync()) {
                    iRemoteTransferAsInterface.asyncCall(request, new com.oplus.epona.ITransferCallback.Stub() { // from class: com.oplus.epona.interceptor.IPCInterceptor.1
                        @Override // com.oplus.epona.ITransferCallback
                        public void onReceive(com.oplus.epona.Response response) throws android.os.RemoteException {
                            callback.onReceive(response);
                        }
                    });
                } else {
                    callback.onReceive(iRemoteTransferAsInterface.call(request));
                }
                return;
            } catch (android.os.RemoteException e_renamed) {
                com.oplus.epona.utils.Logger.e_renamed(TAG, "fail to call %s_renamed#%s_renamed and exception is_renamed %s_renamed", request.getComponentName(), request.getActionName(), e_renamed.toString());
                callback.onReceive(com.oplus.epona.Response.defaultErrorResponse());
                return;
            }
        }
        chain.proceed();
    }
}
