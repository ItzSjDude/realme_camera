package com.oplus.epona.interceptor;

/* loaded from: classes2.dex */
public class CallComponentInterceptor implements com.oplus.epona.Interceptor {
    private static final java.lang.String TAG = "CallComponentInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(com.oplus.epona.Interceptor.Chain chain) {
        final com.oplus.epona.Request request = chain.request();
        com.oplus.epona.DynamicProvider dynamicProviderFindComponent = com.oplus.epona.Epona.findComponent(request.getComponentName());
        if (dynamicProviderFindComponent != null) {
            final com.oplus.epona.Call.Callback callback = chain.callback();
            final java.lang.String string = request.getBundle().getString(com.oplus.epona.Constants.REQUEST_CALLING_PACKAGE_NAME_KEY);
            if (chain.isAsync()) {
                dynamicProviderFindComponent.onCall(request, new com.oplus.epona.Call.Callback() { // from class: com.oplus.epona.interceptor.-$$Lambda$CallComponentInterceptor$HaJXnDRGJuYEbcrwzxOpJHODCQM
                    @Override // com.oplus.epona.Call.Callback
                    public final void onReceive(com.oplus.epona.Response response) {
                        com.oplus.epona.interceptor.CallComponentInterceptor.lambda$intercept$0(string, request, callback, response);
                    }
                });
                return;
            }
            com.oplus.epona.Response responseOnCall = dynamicProviderFindComponent.onCall(request);
            java.lang.Object[] objArr = new java.lang.Object[4];
            if (string == null) {
                string = "";
            }
            objArr[0] = string;
            objArr[1] = request.getComponentName();
            objArr[2] = request.getActionName();
            objArr[3] = responseOnCall;
            com.oplus.epona.utils.Logger.d_renamed(TAG, "Caller(%s_renamed).Component(%s_renamed).Action(%s_renamed) response : %s_renamed", objArr);
            callback.onReceive(responseOnCall);
            return;
        }
        chain.proceed();
    }

    static /* synthetic */ void lambda$intercept$0(java.lang.String str, com.oplus.epona.Request request, com.oplus.epona.Call.Callback callback, com.oplus.epona.Response response) {
        java.lang.Object[] objArr = new java.lang.Object[4];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        objArr[1] = request.getComponentName();
        objArr[2] = request.getActionName();
        objArr[3] = response;
        com.oplus.epona.utils.Logger.d_renamed(TAG, "Caller(%s_renamed).Component(%s_renamed).Action(%s_renamed) response : %s_renamed", objArr);
        callback.onReceive(response);
    }
}
