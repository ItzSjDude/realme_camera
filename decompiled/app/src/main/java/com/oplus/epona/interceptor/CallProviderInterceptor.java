package com.oplus.epona.interceptor;

/* loaded from: classes2.dex */
public class CallProviderInterceptor implements com.oplus.epona.Interceptor {
    private static final java.lang.String TAG = "CallProviderInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(com.oplus.epona.Interceptor.Chain chain) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        final com.oplus.epona.Request request = chain.request();
        java.lang.String componentName = request.getComponentName();
        com.oplus.epona.provider.ProviderInfo providerInfoFindProviderComponent = com.oplus.epona.Epona.findProviderComponent(componentName);
        if (providerInfoFindProviderComponent != null) {
            final com.oplus.epona.Call.Callback callback = chain.callback();
            final java.lang.String string = request.getBundle().getString(com.oplus.epona.Constants.REQUEST_CALLING_PACKAGE_NAME_KEY);
            try {
                java.lang.String actionName = request.getActionName();
                if (chain.isAsync()) {
                    providerInfoFindProviderComponent.getMethod(actionName).invoke(null, request, new com.oplus.epona.Call.Callback() { // from class: com.oplus.epona.interceptor.-$$Lambda$CallProviderInterceptor$p9RvEOLhI9VtfUasM8JFHp65Ovw
                        @Override // com.oplus.epona.Call.Callback
                        public final void onReceive(com.oplus.epona.Response response) {
                            com.oplus.epona.interceptor.CallProviderInterceptor.lambda$intercept$0(string, request, callback, response);
                        }
                    });
                } else {
                    com.oplus.epona.Response response = (com.oplus.epona.Response) providerInfoFindProviderComponent.getMethod(actionName).invoke(null, request);
                    java.lang.Object[] objArr = new java.lang.Object[4];
                    if (string == null) {
                        string = "";
                    }
                    objArr[0] = string;
                    objArr[1] = request.getComponentName();
                    objArr[2] = request.getActionName();
                    objArr[3] = response;
                    com.oplus.epona.utils.Logger.d_renamed(TAG, "Caller(%s_renamed).Component(%s_renamed).Action(%s_renamed) response : %s_renamed", objArr);
                    callback.onReceive(response);
                }
                return;
            } catch (java.lang.Exception e_renamed) {
                com.oplus.epona.utils.Logger.e_renamed(TAG, "fail to run static provider with componentName = %s_renamed and exception is_renamed %s_renamed", componentName, e_renamed.toString());
                callback.onReceive(com.oplus.epona.Response.defaultErrorResponse());
                return;
            }
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
